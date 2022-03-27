public class AutoHelper
{
    public void autoHelp(String[][] matrixTag)
    {
        int newY = 0;
        int newX = 0;
        for(int y = 0; y<4; y++)
        {
            for(int x = 0; x<4; x++)
            {
                if(matrixTag[y][x].equals("[         ]"))
                {
                    newY = y;
                    newX = x;
                }
            }
        }

        if(newY<3)
        {
            matrixTag[newY][newX] = matrixTag[newY+1][newX];
            matrixTag[newY+1][newX] = "[         ]";
        }
        else
        {
            if(newX<3)
            {
                matrixTag[newY][newX] = matrixTag[newY][newX+1];
                matrixTag[newY][newX+1] = "[         ]";
            }
        }

    }
}
