package com.aiyyatti.algorithms.ctci.treeandgraphs;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

/**
 * TODO: Try Topological Sort.
 * TODO: If the dependency was maintained as a separate Data structure like a map it would have been much easier and efficient to solve the problem
 */
public class BuildOrder {
    //////////////
    // SOLUTION //
    //////////////
    class Project {
        String name;
        LinkedList<Project> children = new LinkedList<>();
        int parentDependencyCount = 0;

        public Project(String name) {
            this.name = name;
        }

        public int incrementParentDependencyCount() {
            return parentDependencyCount++;
        }

        public int decrementParentDependencyCount() {
            return parentDependencyCount--;
        }

        public void addChild(Project b) {
            children.add(b);
            b.incrementParentDependencyCount();
        }

        @Override
        public String toString() {
            return name;
        }
    }

    class ProjectBuilder {
        List<Project> projects = new LinkedList<>();

        public ProjectBuilder(List<Project> projects) {
            this.projects = projects;
        }

        public Project[] build() {
            int N = projects.size();
            Project[] output = new Project[N];
            int buildTo = 0;
            int buildFrom = 0;
            buildTo = zeroDeps(projects, output, buildTo);
            while (true) {
                if (buildTo == buildFrom) {
                    if (buildTo < N) throw new RuntimeException("Cyclic");
                    else return output;
                }
                for (; buildFrom < buildTo; buildFrom++) {
                    List<Project> children = output[buildFrom].children;
                    for (Project child : children) {
                        child.decrementParentDependencyCount();
                    }
                    buildTo = zeroDeps(children, output, buildTo);
                }
            }
        }

        public int zeroDeps(List<Project> projects, Project[] output, int buildTo) {
            for (Project project : projects) {
                if (project.parentDependencyCount == 0) {
                    output[buildTo] = project;
                    buildTo++;
                }
            }
            return buildTo;
        }
    }

    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void ctciTest() {
        Project a = new Project("a");
        Project b = new Project("b");
        Project c = new Project("c");
        Project d = new Project("d");
        Project e = new Project("e");
        Project f = new Project("f");
        a.addChild(d);
        f.addChild(b);
        b.addChild(d);
        f.addChild(a);
        d.addChild(c);
        List<Project> projects = new LinkedList<>();
        projects.add(a);
        projects.add(b);
        projects.add(c);
        projects.add(d);
        projects.add(e);
        projects.add(f);
        assertEquals("[e, f, b, a, d, c]", Arrays.toString(new ProjectBuilder(projects).build()));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void cyclicTest() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Cyclic");
        Project a = new Project("a");
        Project b = new Project("b");
        Project c = new Project("c");
        Project d = new Project("d");
        Project e = new Project("e");
        Project f = new Project("f");
        a.addChild(d);
        c.addChild(a);
        f.addChild(b);
        b.addChild(d);
        f.addChild(a);
        d.addChild(c);
        List<Project> projects = new LinkedList<>();
        projects.add(a);
        projects.add(b);
        projects.add(c);
        projects.add(d);
        projects.add(e);
        projects.add(f);
        new ProjectBuilder(projects).build();
    }

}
