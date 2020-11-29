package com.sy.hr.dg.common.search;

import com.sy.hr.dg.problem.vo.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Specification<T> {

    public static Specification<Problem> getWhereProblemTitle( String problemTitle ) {
        return new Specification<Problem>() {

        };
    }

}
