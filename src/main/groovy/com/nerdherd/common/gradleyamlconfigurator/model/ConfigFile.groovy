package com.nerdherd.common.gradleyamlconfigurator.model

/**
 * Created by NerdHerd on 2016. 7. 30..
 */
class ConfigFile {

    def String path
    def File file
    def String category
    def List<String> tags
    def boolean secret

    ConfigFile(String path, File file, String category, List<String> tags, boolean secret) {
        this.path = path
        this.file = file
        this.category = category
        this.tags = tags
        this.secret = secret
    }
}
