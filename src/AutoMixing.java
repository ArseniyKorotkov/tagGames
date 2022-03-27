public class AutoMixing
{
    public void mix(String[][] matrixTag, int step)
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

        //Down
        if(step<=2 || step>=9 && step<=11
                || step>=20 && step<=21 || step>=29 && step<=30)
        {
            matrixTag[newY][newX] = matrixTag[newY-1][newX];
            matrixTag[newY-1][newX] = "[         ]";
        }

        //Right
        if(step>=3 && step<=4 || step>=12 && step<=13 || step>=22 && step<=24 || step>=31 && step<=33)
        {
            matrixTag[newY][newX] = matrixTag[newY][newX-1];
            matrixTag[newY][newX-1] = "[         ]";
        }

        //Up
        if(step>=5 && step<=7 || step>=14 && step<=16 || step==25 || step>=34 && step<=36)
        {
            matrixTag[newY][newX] = matrixTag[newY+1][newX];
            matrixTag[newY+1][newX] = "[         ]";
        }

        //Left
        if(step==8 || step>=17 && step<=19 || step>=26 && step<=28 || step>=37 && step<=39 )
        {
            matrixTag[newY][newX] = matrixTag[newY][newX+1];
            matrixTag[newY][newX+1] = "[         ]";
        }

    }
}
