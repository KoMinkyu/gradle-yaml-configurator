package com.nerdherd.common.gradleyamlconfigurator.util

import com.nerdherd.common.gradleyamlconfigurator.model.ConfigFile
import groovy.io.FileType

/**
 * Created by NerdHerd on 2016. 7. 30..
 */
class ConfigDirParser {

    static ConfigFile[] parse(String[] paths) {
        def configFiles = []
        paths.each {path ->
            configFiles.addAll(parse(path))
        }
        return configFiles
    }

    static ConfigFile[] parse(String path) {
        def files = [];
        (new File(path)).eachFileRecurse (FileType.FILES) { file ->
            files << file
        }

        def configs = files.collect { file ->
            def matcher = (file.path =~ ~/\\/([A-Za-z]{1,})\.([A-Za-z\.]{1,}\.)?(yml|yaml)(.secret)?/)
            if (matcher.size() < 1 || matcher[0].size < 5)
                return null

            def category = matcher[0][1]
            def tags
            if (matcher[0][2] == null)
                tags = []
            else
                tags = matcher[0][2].tokenize('.')
            def secret = matcher[0][4] != null
            return new ConfigFile(
                    file.path,
                    file,
                    category as String,
                    tags,
                    secret
            )
        }

        return configs
    }

}
