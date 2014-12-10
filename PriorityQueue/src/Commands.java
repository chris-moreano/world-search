

public class Commands {
    private String command;	//	INSTRUCTIONS
    private String firstP;		//	PARAMETER ONE
    private String secondP;	// 	PARAMETER TWO

    public Commands(String cmd, String node, String change)
    {
        this.command = cmd; 
        this.firstP = node;
        this.secondP = change;
    }
    
    public Commands(String cmd, String node)
    {
        this.command = cmd; 
        this.firstP = node;
    }
    
    public Commands(String cmd)
    {
    	this.command = cmd;
    }

    public String getParam()
    {
        return firstP;
    }
    
    public String getParamTwo()
    {
        return secondP;
    }
    public String getCMD()
    {
        return command;
    }

    /*
    @Override
    public String toString() 
    {
    }
    */
}

