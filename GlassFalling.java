/**
 * Glass Falling
 */
public class GlassFalling {

  // Do not change the parameters!
  public int glassFallingRecur(int floors, int sheets) {
     
      if (sheets == 1) {  
          return floors;
      }
      if (floors == 1 || floors == 0) {  
          return floors;    
      }
      
      int result;  
      int minNumTrials = 999999;

       for (int floorCounter = 1; floorCounter <= floors; floorCounter++)  
      {  
          result = Math.max(glassFallingRecur(sheets-1, floorCounter-1), glassFallingRecur(sheets, floors-floorCounter));  
          if (result < minNumTrials) {  
              minNumTrials = result;  
          }
      }  
    
      return minNumTrials + 1;  
  }
   // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int glassFallingMemoized(int glassSheets,int floors) {
       int result; 
      
       int floorGlass[][] = new int[glassSheets+1][floors+1]; 
        
       for (int i = 1; i <= glassSheets; i++) 
       { 
           floorGlass[i][1] = 1; 
           floorGlass[i][0] = 0; 
       } 
          
       for (int j = 1; j <= floors; j++) { 
           floorGlass[1][j] = j; 
       }

       for (int i = 2; i <= glassSheets; i++) 
       { 
           for (int j = 2; j <= floors; j++) 
           { 
               floorGlass[i][j] = 999999; 
               for (int x = 1; x <= j; x++) 
               { 
                   result = 1 + Math.max(floorGlass[i-1][x-1], floorGlass[i][j-x]); 
                    if (result < floorGlass[i][j]) { 
                        floorGlass[i][j] = result; 
                    }
               } 
           } 
       } 
          return floorGlass[glassSheets][floors]; 
  }

    // Do not change the parameters!
  public int glassFallingBottomUp(int floors, int sheets) {
      
      int result; 
      
      int floorGlass[][] = new int[sheets+1][floors+1]; 
       
      for (int i = 1; i <= sheets; i++) 
      { 
          floorGlass[i][1] = 1; 
          floorGlass[i][0] = 0; 
      } 
         
      for (int j = 1; j <= floors; j++) { 
          floorGlass[1][j] = j; 
      }
      
      for (int i = 2; i <= sheets; i++) 
      { 
          for (int j = 2; j <= floors; j++) 
          { 
              floorGlass[i][j] = 999999; 
              for (int x = 1; x <= j; x++) 
              { 
                  result = 1 + Math.max(floorGlass[i-1][x-1], floorGlass[i][j-x]); 
                   if (result < floorGlass[i][j]) { 
                       floorGlass[i][j] = result; 
                   }
              } 
          } 
      } 
         
      return floorGlass[sheets][floors]; 
  }

  
  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();

      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Recur = gf.glassFallingRecur(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Recur + " " + minTrials2Bottom);
  }
}