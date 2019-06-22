package com.aiyyatti.algorithms.ctci.treeandgraphs;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Iterator;
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
    public List<Project> doBuildOrder(List<Project> projects) {
        List<Project> startOnes = getZeroDepsOnes(projects);
        List<Project> output = new LinkedList<>();
        build(startOnes, output);
        if (projects.size() > output.size()) throw new RuntimeException("Cyclic");
        return output;
    }

    public void build(List<Project> projects, List<Project> output) {
        if (projects.size() == 0) return;
        for (Iterator<Project> itr = projects.iterator(); itr.hasNext(); ) {
            Project project = itr.next();
            if (project.zeroDepCount()) {
                output.add(project);
                for (Project child : project.children) child.decrementDeps();
                build(project.children, output);
            }
        }
    }

    public List<Project> getZeroDepsOnes(List<Project> projects) {
        List<Project> output = new LinkedList<>();
        for (Project project : projects) {
            if (project.zeroDepCount()) output.add(project);
        }
        return output;
    }

    class Project {
        String name;
        LinkedList<Project> children = new LinkedList<>();
        int parentDependencyCount = 0;

        public Project(String name) {
            this.name = name;
        }

        public int incrementDeps() {
            return parentDependencyCount++;
        }

        public void decrementDeps() {
            parentDependencyCount--;
        }

        public int getDepCount() {
            return parentDependencyCount;
        }

        public boolean zeroDepCount() {
            return parentDependencyCount == 0;
        }

        public void addChild(Project b) {
            children.add(b);
            b.incrementDeps();
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
        assertEquals("[e, f, b, a, d, c]", doBuildOrder(projects).toString());
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
        doBuildOrder(projects);
    }

}
