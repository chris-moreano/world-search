
public class ws_board {

	public char[][] list;	// Keywords are stored here
	public char[][] board;	// Board is stored here
	public char[][] output; // Solved Puzzle is stored here
	public int currentWord; // Address of current word
	public int foundRow;	// Address of found Row
	public int foundColumn;	// Address of found Column
	
	public ws_board(String file)
	{
		LoadFile temp = new LoadFile(file);
		board = new char[temp.grid_row][temp.grid_columns];
		output = new char[temp.grid_row][temp.grid_columns]; 
		
		for(int i=0; i<temp.tdArray.length; i++)
			  for(int j=0; j<temp.tdArray[0].length; j++)
			    board[i][j]=temp.tdArray[i][j];
		
		System.out.println("**Printing*Board**");
		System.out.println("**Board Size **" + board.length +"x" + board[0].length);

		print(board);
		fillWithSpaces(output);
		list =  new char[temp.wordList.length][];
		
    	System.out.println("**Printing*Word*List**");

		 for(int i = 0; i <temp.wordList.length; i++)
	        { 
			 	
	        	list[i] = temp.wordList[i];
	        	System.out.print(list[i]);
	        	System.out.print(" ");
	        }
     	//System.out.println();
    	System.out.println("\n**Printing*Findings**");
    	
    	findFirstLetter();
      
			System.out.println("==Printing Output==");

			       print(output);
		    }


		    public void findFirstLetter()
		    {
				 for(int i = 0; i < list.length; i++)
					{        
					    currentWord = i;  
						for(int r = 0; r < board.length; r++)
					        {
					        for(int c = 0; c < board[0].length; c++)
					            {
					                if(list[currentWord][0] == board[r][c])
					                {
					                    foundRow = r;
					                    foundColumn = c;
					                    checkEachDirection();
					                }
					            }
					        }
					}
		    }

		    public void checkEachDirection()
		    {
		        checkForwards();		// Checks from West to East
		        checkBackwards();		// Checks from Right to Left
		        checkUp();		    	// Checks from South to North
		        checkDown();			// Checks from North to South	        
		        checkDiagonalDownA();	// Checks towards Southeast
		        checkDiagonalUpA();		// Checks towards Northwest
		        checkDiagonalDownB();	// Checks towards Southwest
		        checkDiagonalUpB();		// Checks towards Northeast
		    }

		    public void checkForwards()
		    {
		        for(int i = 1; i < list[currentWord].length; i++)
		        {
		            if(foundColumn + i > board.length - 1) return;
		            if(list[currentWord][i] != board[foundRow][foundColumn + i]) return;
		        }
		        //if we got to here, update the output
		        for(int i = 0; i < list[currentWord].length; i++)
		        {
		            output[foundRow][foundColumn + i] = list[currentWord][i];
		        }
		        
		        System.out.println(String.valueOf(list[currentWord]) + " was found @ ("+ (foundRow+1) + "," + (foundColumn+1) + ")-("+ 

		(foundRow+1) + "," + (foundColumn + list[currentWord].length) +")" );
		        return;
		    }

		    public void checkBackwards()
		    {
		        for(int i = 1; i < list[currentWord].length; i++)
		        {
		            if(foundColumn - i < 0) return;
		            if(list[currentWord][i] != board[foundRow][foundColumn - i]) return;
		        }
		        //if we got to here, update the output
		        for(int i = 0; i < list[currentWord].length; i++)
		        {
		            output[foundRow][foundColumn - i] = list[currentWord][i];
		        }
		        
		        System.out.println(String.valueOf(list[currentWord]) + " was found @ ("+ (foundRow+1) + "," + (foundColumn+1)+")-("+ (foundRow+1) +  "," + ((foundColumn - list[currentWord].length)+2) + ")" );
		        
		        return;
		    }
		    public void checkDown()
		    {
		        for(int i = 1; i < list[currentWord].length; i++)
		        {
		        	// if the word is bigger than the spaces in board , return
		            if(foundRow+list[currentWord].length > board[0].length -1) 
		            	
		            	{return;}
		            if((foundRow + i) == (board.length)) 
		            {return;}

		            if((list[currentWord][i]) !=  (board[foundRow+i][foundColumn]))
		            	{
		            	//System.out.println(i);
		             	return;
		            	}
		            
		           // System.out.println("D"+i);
		        }
		        //if we got to here, update the output
		        for(int i = 0; i < list[currentWord].length; i++)
		        {
		        	//System.out.println(list[0][1]);
		            output[foundRow + i][foundColumn]= list[currentWord][i];
		           // System.out.println(foundRow + "-" + foundColumn);
		        }
		        
		        System.out.println(String.valueOf(list[currentWord]) + " was found @ ("+ (foundRow+1) + "," + (foundColumn+1)+ 

		")-("+ (foundRow +list[currentWord].length) + "," + (foundColumn+1) + ")" );
		        
		        return;
		    }
		    
		    public void checkUp()
		    {
		        for(int i = 1; i < list[currentWord].length; i++)
		        {
		        	// if the word is bigger than the spaces in board , return
		            if(foundRow-list[currentWord].length <  0) 
		            	{return;}
		            
		            if(list[currentWord][i] !=  board[foundRow - i][foundColumn])
		            	{
		            	//System.out.println(i);
		            	return;
		            	}
		            
		           // System.out.println("D"+i);
		        }
		        //if we got to here, update the output
		        for(int i = 0; i < list[currentWord].length; i++)
		        {
		        	//System.out.println(list[0][1]);
		            output[foundRow - i][foundColumn]= list[currentWord][i];
		           // System.out.println(foundRow + "-" + foundColumn);
		        }
		        
		        System.out.println(String.valueOf(list[currentWord]) + " was found @ ("+ (foundRow+1) + "," + (foundColumn+1)+ 

		")-("+ ((foundRow-list[currentWord].length)+2) + "," + (foundColumn+1) + ")" );
		        
		        return;
		    }
		    // Diagonal that moves from left -> down -> right
		    public void checkDiagonalDownA()
		    {
		        for(int i = 1; i < list[currentWord].length; i++)
		        {
		            if(foundColumn + i > board.length - 1) return;
		            if(foundRow + i > board.length - 1) return;
		            //if(foundRow - i < 0 ) return;
		            
		            //System.out.println(board[28][2]);
		            if(list[currentWord][i] != board[foundRow + i][foundColumn + i]) return;
		        }
		        //if we got to here, update the output
		        for(int i = 0; i < list[currentWord].length; i++)
		        {
		            output[foundRow + i][foundColumn + i] = list[currentWord][i];
		        }
		        
		        System.out.println(String.valueOf(list[currentWord]) + " was found @ ("+ (foundRow+1) + "," + (foundColumn

		+1)+")-("+( foundRow +list[currentWord].length)+ "," + (foundColumn + list[currentWord].length ) + ")" );
		        
		        return;
		    }

		    // Diagonal that moves from right -> up -> left
		    public void checkDiagonalUpA()
		    {
		        for(int i = 1; i < list[currentWord].length; i++)
		        {
		            if(foundColumn - i <=  0) return;
		            if(foundRow - 1 <= 0) return;
		            if((foundColumn - i)  == ( board.length)) return ; 
		            if(list[currentWord][i] != board[foundRow - i][foundColumn - i]) return;
		        }
		        //if we got to here, update the output
		        for(int i = 0; i < list[currentWord].length; i++)
		        {
		            output[foundRow - i][foundColumn - i] = list[currentWord][i];
		        }
		        
		        System.out.println(String.valueOf(list[currentWord]) + " was found @ ("+ (foundRow+1) + "," + (foundColumn+1)

		+")-("+( (foundRow -list[currentWord].length) +2)+ "," + ((foundColumn - list[currentWord].length ) +2)+ ")" );
		        
		        return;
		    }
		    ///// goes from top right , moves down right
		    public void checkDiagonalDownB()
		    {
		        for(int i = 1; i < list[currentWord].length; i++)
		        {
					if((foundRow + i)  >= ( board.length)) return ; 		        	
					if(foundColumn- i  >= board.length) return;
					if(foundColumn - i < 0 ) return;
		            if(list[currentWord][i] != board[foundRow + i][foundColumn - i]) return;
		        }
		        //if we got to here, update the output
		        for(int i = 0; i < list[currentWord].length; i++)
		        {
		            output[foundRow + i][foundColumn - i] = list[currentWord][i];
		        }
		        
		        System.out.println(String.valueOf(list[currentWord]) + " was found @ ("+ (foundRow+1) + "," + (foundColumn+1)

		+")-("+( (foundRow -list[currentWord].length) +2)+ "," + ((foundColumn - list[currentWord].length ) +2)+ ")" );
		        
		        return;		    	
		    }
		    
			public void checkDiagonalUpB()
			{
				for(int i = 1; i < list[currentWord].length; i++)
				{
					//if(foundColumn - i <=  0) return;
					if(foundRow -i < 0) return;
					if((foundColumn + i)  >= ( board.length)) return ; 
					if((foundRow - i)  >= ( board.length)) return ; 
					if(list[currentWord][i] != board[foundRow - i][foundColumn + i]) return;
				}
				for(int i = 0; i < list[currentWord].length; i++)
				{
					output[foundRow - i][foundColumn + i] = list[currentWord][i];
				}
				System.out.println(String.valueOf(list[currentWord]) + " was found @ ("+ (foundRow+1) + "," + (foundColumn

						+1)+")-("+( foundRow - list[currentWord].length + 2)+  "," + (foundColumn - list[currentWord].length + 2) +")" );

				return;
			}
/**
 */
		    public void print(char [][] b)
		    {
		        for(int i = 0; i < b.length; i++)
		        {
		            for(int j = 0; j < b[0].length; j++)
		            {
		                System.out.print(b[i][j] + " ");
		            }
		            System.out.println();
		        }
		        //System.out.println();
		    }

		    public void fillWithSpaces(char[][] board)
		    {
		        for(int i = 0; i < board.length; i++)
		        {
		            for(int j = 0; j < board[0].length; j++)
		            {
		                board[i][j] = '-';
		            }
		        }
		    }
	}

