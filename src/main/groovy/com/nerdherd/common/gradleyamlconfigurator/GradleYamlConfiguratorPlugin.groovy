package com.nerdherd.common.gradleyamlconfigurator

import com.nerdherd.common.gradleyamlconfigurator.model.ConfigFile
import com.nerdherd.common.gradleyamlconfigurator.util.ConfigDirParser
import com.sun.tools.internal.jxc.ap.Const
import org.gradle.api.Plugin
import org.gradle.api.Project
import groovy.io.FileType

/**
 * Created by NerdHerd on 2016. 7. 30..
 */
class GradleYamlConfiguratorPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        def extension = project.extensions.findByName(Constant.EXTENSION_NAME) as GradleYamlConfiguratorPluginExtension
        if (extension == null)
            project.extensions.add(
                    Constant.EXTENSION_NAME,
                    new GradleYamlConfiguratorPluginExtension()
            )

        def configs = extension.configs

        def configFiles = ConfigDirParser.parse(extension.configPaths as String[])

        println 'asdf'

    }

    class GradleYamlConfiguratorPluginExtension {
        def configPaths = ['./config']
        def configs = [:]
    }

}
