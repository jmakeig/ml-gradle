package com.marklogic.gradle.task.cpf

import org.gradle.api.tasks.TaskAction

import com.marklogic.appdeployer.command.Command
import com.marklogic.appdeployer.impl.SimpleAppDeployer
import com.marklogic.gradle.task.MarkLogicTask

class DeployCpfTask extends MarkLogicTask {

    @TaskAction
    void deployCpf() {
        List<Command> commands = getProject().property("mlCpfCommands")
        SimpleAppDeployer deployer = new SimpleAppDeployer(getManageClient(), getAdminManager())
        deployer.setCommands(commands)
        deployer.deploy(getAppConfig())
    }
}