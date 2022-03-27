import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
    public static void main(String[] args)
    {
        //делаем окошко видимым
        GUI window = new GUI();
        window.setVisible(true);

        //создаем матрицу пятнашек
        String [][] matrixTag = new String[4][4];

        //заполняем матрицу пятнашек
        new StartingCompletion().completion(matrixTag);

        //разрешение действий в  while(true) по кнопке "Start"
        final boolean[] checkStart = {false};
        //разрешение действий в  while(true) по кнопке "Finish"
        final boolean[] checkFinish = {false};

        /**
         * ДЕЙСТВИЕ ДЛЯ КНОПКИ "DOWN"
         */
        class Down implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!window.space.getText().equals("Your win!!!")
                        && checkStart[0] == false && checkFinish[0] == false )
                {
                    window.space.setText("");
                    window.space2.setText("");

                    int newY = new YXLocation().isThere(matrixTag)[0];
                    int newX = new YXLocation().isThere(matrixTag)[1];

                    if(newY > 0)
                    {
                        matrixTag[newY][newX] = matrixTag[newY-1][newX];
                        matrixTag[newY-1][newX] = "[         ]";
                    }
                }

            }
        }

        /**
         * ДЕЙСТВИЕ ДЛЯ КНОПКИ "UP"
         */
        class Up implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!window.space.getText().equals("Your win!!!")
                        && checkStart[0] == false && checkFinish[0] == false)
                {
                    window.space.setText("");
                    window.space2.setText("");

                    int newY = new YXLocation().isThere(matrixTag)[0];
                    int newX = new YXLocation().isThere(matrixTag)[1];

                    if(newY < 3)
                    {
                        matrixTag[newY][newX] = matrixTag[newY+1][newX];
                        matrixTag[newY+1][newX] = "[         ]";
                    }
                }

            }
        }

        /**
         * ДЕЙСТВИЕ ДЛЯ КНОПКИ "LEFT"
         */
        class Left implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!window.space.getText().equals("Your win!!!")
                        && checkStart[0] == false && checkFinish[0] == false)
                {
                    window.space.setText("");
                    window.space2.setText("");

                    int newY = new YXLocation().isThere(matrixTag)[0];
                    int newX = new YXLocation().isThere(matrixTag)[1];

                    if(newX < 3)
                    {
                        matrixTag[newY][newX] = matrixTag[newY][newX+1];
                        matrixTag[newY][newX+1] = "[         ]";
                    }
                }

            }
        }

        /**
         * ДЕЙСТВИЕ ДЛЯ КНОПКИ "RIGHT"
         */
        class Right implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!window.space.getText().equals("Your win!!!")
                        && checkStart[0] == false && checkFinish[0] == false)
                {
                    window.space.setText("");
                    window.space2.setText("");

                    int newY = new YXLocation().isThere(matrixTag)[0];
                    int newX = new YXLocation().isThere(matrixTag)[1];

                    if(newX > 0)
                    {
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
                    }
                }

            }
        }


        /**
         * ДЕЙСТВИЕ ДЛЯ КНОПКИ "Start"
         */
        class Start implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(checkStart[0] == false && checkFinish[0] == false)
                {
                    checkStart[0] = true;
                }
            }
        }

        /**
         * ДЕЙСТВИЕ ДЛЯ КНОПКИ "Finish"
         */
        class Finish implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(checkStart[0] == false && checkFinish[0] == false)
                {
                    checkFinish[0] = true;
                }
            }
        }

        /**
         * Присвоение действий кнопкам
         */
        window.buttonForDown.addActionListener(new Down());
        window.buttonForUp.addActionListener(new Up());
        window.buttonForLeft.addActionListener(new Left());
        window.buttonForRight.addActionListener(new Right());
        window.buttonForStart.addActionListener(new Start());
        window.buttonForFinish.addActionListener(new Finish());

        /**
         * Визуализация матрицы пятнашек
         */
        int stepStart = 0;
        int[] searchStep = {0};
        int[] stageFinish = {0};
        int[] stagePermutation = {0};
        boolean[] jobFinish = {false};

        while(true)
        {
            //визуализация работы в окошке GUI
            new Visible().see(window, matrixTag);

            /**
             * Действия по вмешательству кнопки "Start"
             */
            if(checkStart[0])
            {
                if(matrixTag[3][3].equals("[         ]") || stepStart != 0)
                {
                    window.space.setText("Wait");
                    window.space2.setText("Mixing");

                    new AutoMixing().mix(matrixTag, stepStart);
                    stepStart++;
                    if(stepStart == 40)
                    {
                        checkStart[0] = false;
                        stepStart = 0;
                        window.space.setText("");
                        window.space2.setText("");
                    }
                }
                else
                {
                    window.space.setText("Wait");
                    window.space2.setText("Mixing");
                    new AutoHelper().autoHelp(matrixTag);
                }

                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }

            /**
             * Действия по вмешательству кнопки "Finish"
             */
            if(checkFinish[0])
            {
                window.space.setText("Wait");
                window.space2.setText("Completion");

                if(searchStep[0] == 0)
                {
                    new AutoHelper().autoHelp(matrixTag);
                    if(!matrixTag[3][3].equals("[         ]"))
                    {
                        searchStep[0]--;
                        System.out.println("RETURN");
                    }
                }
                else
                {
                    new AutoCompleter().autoComp(matrixTag, searchStep, stageFinish, jobFinish, stagePermutation);
                }
                searchStep[0]++;
                if(searchStep[0] > 24)
                {
                    searchStep[0] = 1;
                }

                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }

            //визуализация сообщения о конце игры
            if( matrixTag[0][0].equals("[  01  ]") && matrixTag[0][1].equals("[  02  ]")
                    && matrixTag[0][2].equals("[  03  ]") && matrixTag[0][3].equals("[  04  ]")
                    && matrixTag[1][0].equals("[  05  ]") && matrixTag[1][1].equals("[  06  ]")
                    && matrixTag[1][2].equals("[  07  ]") && matrixTag[1][3].equals("[  08  ]")
                    && matrixTag[2][0].equals("[  09  ]") && matrixTag[2][1].equals("[  10  ]")
                    && matrixTag[2][2].equals("[  11  ]") && matrixTag[2][3].equals("[  12  ]")
                    && matrixTag[3][0].equals("[  13  ]") && matrixTag[3][1].equals("[  14  ]")
                    && matrixTag[3][2].equals("[  15  ]") && matrixTag[3][3].equals("[         ]"))
            {
                window.space.setText("Your win!!!");
                window.space2.setText("Play again?");
                checkFinish[0] = false;
                searchStep[0] = 0;
                stageFinish[0] = 0;
                stagePermutation[0] = 0;
                jobFinish[0] = false;
            }

        }

    }
}
