public class YXLocation
{
    public int[] isThere(String[][] matrixTag)
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
        int[] adress = new int[2];
        adress[0] = newY;
        adress[1] = newX;
        return adress;
    }
}
