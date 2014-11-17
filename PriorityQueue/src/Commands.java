

public class Commands {
    private String command;	//	INSTRUCTIONS
    private int firstP;		//	PARAMETER ONE
    private int secondP;	// 	PARAMETER TWO

    public Commands(String cmd, int node, int change)
    {
        this.command = cmd; 
        this.firstP = node;
        this.secondP = change;
    }
    
    public Commands(String cmd, int node)
    {
        this.command = cmd; 
        this.firstP = node;
    }

    public int getParam()
    {
        return firstP;
    }
    
    public int getParamTwo()
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

