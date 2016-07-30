package com.nerdherd.common.gradleyamlconfigurator

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * Created by NerdHerd on 2016. 7. 30..
 */
class GradleYamlConfiguratorPluginTest {

    @Test
    public void greeterPluginAddsGreetingTaskToProject() {
        Project project = ProjectBuilder.builder().build()

        project.extensions.add(
                Constant.EXTENSION_NAME,
                new GradleYamlConfiguratorPlugin.GradleYamlConfiguratorPluginExtension()
        )

        project.apply plugin: 'gradle-yaml-configurator'

//        assertTrue(project.tasks.hello instanceof GreetingTask)
    }

}
