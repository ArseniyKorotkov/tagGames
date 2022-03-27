public class StartingCompletion
{
    public void completion(String [][] matrixTag)
    {
        int numberInMatrix = 1;

        for(int y = 0; y<4; y++)
        {
            for(int x = 0; x<4; x++)
            {
                if(String.valueOf(numberInMatrix).length() == 1)
                {
                    matrixTag[y][x] = "[  0"+ String.valueOf(numberInMatrix) + "  ]";
                }
                else
                {
                    matrixTag[y][x] = "[  "+ String.valueOf(numberInMatrix) + "  ]";
                }
                numberInMatrix++;
            }
        }

        matrixTag[3][3] = "[         ]";

    }
}
