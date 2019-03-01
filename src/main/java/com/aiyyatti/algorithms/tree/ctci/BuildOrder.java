package com.aiyyatti.algorithms.tree.ctci;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
 * projects, where the second project is dependent on the first project). All of a project's dependencies
 * must be built before the project is. Find a build order that will allow the projects to be built. If there
 * is no valid build order, return an error.
 * <p>
 * TODO: If the dependency was maintainted as a separate Data structure like a map it would have been much easier and efficient to solve the problem
 */
public class BuildOrder {
    enum Status {
        NOT_BUILT, BUILT
    }

    class BuildTool {
        Project[] projects = null;
        int offset = 0;
        Project[] buildOrder = null;

        public BuildTool(Project... projects) {
            this.projects = projects;
            buildOrder = new Project[projects.length];
        }

        public Project[] doBuild() {
            while (offset < projects.length) {
                for (int i = 0; i < projects.length; i++) {
                    Project project = projects[i];
                    if (project.status == Status.NOT_BUILT && project.areAllDependentProjectsBuilt()) {
                        buildOrder[offset++] = project;
                        project.status = Status.BUILT;
                    }
                }
            }
            return buildOrder;
        }
    }

    class Project {
        private String name;
        private Status status = Status.NOT_BUILT;
        private Project[] dependencies = null;

        public Project(String name) {
            this.name = name;
        }

        public Project(String name, Project... dependencies) {
            this.name = name;
            this.dependencies = dependencies;
        }

        public boolean areAllDependentProjectsBuilt() {
            if (dependencies == null) return true;
            for (int i = 0; i < dependencies.length; i++) {
                if (dependencies[i].status == Status.NOT_BUILT) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        Project fileWriter = new Project("File Writer");
        Project consoleWriter = new Project("Console Writer");
        Project logger = new Project("Logger", fileWriter, consoleWriter);
        Project appleMaps = new Project("Apple Maps", logger);
        Project grl = new Project("Global Resource Locator", appleMaps, logger);
        Project appleDotCom = new Project("appleDotCom", grl);
        BuildTool buildTool = new BuildTool(consoleWriter, logger, appleDotCom, fileWriter, appleMaps, grl);
        String output = Arrays.stream(buildTool.doBuild()).map(Project::toString).collect(Collectors.joining("->"));
        TestCase.assertEquals("Console Writer->File Writer->Logger->Apple Maps->Global Resource Locator->appleDotCom", output);
    }
}
