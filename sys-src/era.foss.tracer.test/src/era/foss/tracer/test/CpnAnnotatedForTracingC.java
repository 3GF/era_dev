package era.foss.tracer.test;

import era.foss.tracing.annotations.Requirement;

@Requirement(reqid = "100000_so", reviewers = {"CPN"})
public class CpnAnnotatedForTracingC {
	
	@Requirement(reqid = "200000_so", reviewers = {"Goo"})
	public Integer somemember = null;
	
    @Requirement(reqid = "300000_so", reviewers = {"CPN", "Poldi"})
    @Override
    public String toString() {
        return "Hello Tracer";
    }

    @Requirement(reqid = "300001_so", reviewers = {"Foo"})
    public String foo() {
        return "Hello Tracer";
    }
    
}
