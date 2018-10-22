package lab09.fin;

public class EmployeeDataAccessor {

	@Transactional(value=true, commitType=CommitType.XA)
	public void execute() {
	  // Do something
	}
}
