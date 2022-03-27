public class AutoCompleter
{//начало класса
    public void autoComp(String [][] matrixTag, int[] searchStep,
                         int[] stageFinish, boolean[] jobFinish, int[] stagePermutation)
    {//начало метода
        /**
         *
         * ПРЕДВАРИТЕЛЬНАЯ ЧАСТЬ КОДА
         *
         */
        int newY = new YXLocation().isThere(matrixTag)[0];
        int newX = new YXLocation().isThere(matrixTag)[1];

        //серия1
        String ask = "";
        if(!matrixTag[0][0].equals("[  03  ]") && stageFinish[0] < 4)
        {
            //stageFinish[0] = 0; поиск и постановка на предварительное место числа 3
            ask = "[  03  ]";
        }
        if(matrixTag[0][0].equals("[  03  ]") && stageFinish[0] < 4)
        {
            stageFinish[0] = 1;//поиск и постановка на предварительное место числа 2
            ask = "[  02  ]";
        }
        if( matrixTag[0][0].equals("[  03  ]") && matrixTag[1][0].equals("[  02  ]") && stageFinish[0] < 4 )
        {
            stageFinish[0] = 2;//поиск и постановка на предварительное место числа 4
            ask = "[  04  ]";
        }
        if( matrixTag[0][0].equals("[  03  ]") && matrixTag[1][0].equals("[  02  ]") &&
                matrixTag[0][1].equals("[  04  ]") && stageFinish[0] < 4)
        {
            stageFinish[0] = 3;//поиск и постановка на предварительное место числа 1
            ask = "[  01  ]";
        }
        if( matrixTag[0][0].equals("[  03  ]") && matrixTag[1][0].equals("[  02  ]") &&
                matrixTag[2][0].equals("[  01  ]") && matrixTag[0][1].equals("[  04  ]") && stageFinish[0] < 4)
        {
            stageFinish[0] = 4;//постановка на окончательное место чисел 1, 2, 3 и 4
            ask = "";
        }

        //серия2
        if( matrixTag[0][0].equals("[  01  ]") && matrixTag[0][1].equals("[  02  ]") &&
                matrixTag[0][2].equals("[  03  ]") && matrixTag[0][3].equals("[  04  ]") && stageFinish[0] < 8)
        {
            stageFinish[0] = 5;//поиск и постановка на предварительное место числа 13
            ask = "[  13  ]";
        }
        if(matrixTag[0][0].equals("[  01  ]") && matrixTag[0][1].equals("[  02  ]") &&
                matrixTag[0][2].equals("[  03  ]") && matrixTag[0][3].equals("[  04  ]") &&
                matrixTag[1][0].equals("[  13  ]") && stageFinish[0] < 8)
        {
            stageFinish[0] = 6;//поиск и постановка на предварительное место числа 9
            ask = "[  09  ]";
        }
        if(matrixTag[0][0].equals("[  01  ]") && matrixTag[0][1].equals("[  02  ]") &&
                matrixTag[0][2].equals("[  03  ]") && matrixTag[0][3].equals("[  04  ]") &&
                matrixTag[1][0].equals("[  13  ]") && matrixTag[1][1].equals("[  09  ]") && stageFinish[0] < 8)
        {
            stageFinish[0] = 7;//поиск и постановка на предварительное место числа 5
            ask = "[  05  ]";
        }
        if(matrixTag[0][0].equals("[  01  ]") && matrixTag[0][1].equals("[  02  ]") &&
                matrixTag[0][2].equals("[  03  ]") && matrixTag[0][3].equals("[  04  ]") &&
                matrixTag[1][0].equals("[  13  ]") && matrixTag[1][1].equals("[  09  ]") &&
                matrixTag[1][2].equals("[  05  ]") && stageFinish[0] < 8)
        {
            stageFinish[0] = 8;//постановка на окончательное место чисел 13, 9, и 5
            ask = "";
        }

        //серия3
        if(matrixTag[0][0].equals("[  01  ]") && matrixTag[0][1].equals("[  02  ]") &&
                matrixTag[0][2].equals("[  03  ]") && matrixTag[0][3].equals("[  04  ]") &&
                matrixTag[1][0].equals("[  05  ]") && matrixTag[2][0].equals("[  09  ]") &&
                matrixTag[3][0].equals("[  13  ]") && stageFinish[0] <= 9)
        {
            stageFinish[0] = 9;//поиск и постановка на место числа 14
            ask = "[  14  ]";
        }


        //серия4
        if(matrixTag[0][0].equals("[  01  ]") && matrixTag[0][1].equals("[  02  ]") &&
                matrixTag[0][2].equals("[  03  ]") && matrixTag[0][3].equals("[  04  ]") &&
                matrixTag[1][0].equals("[  05  ]") && matrixTag[2][0].equals("[  09  ]") &&
                matrixTag[3][0].equals("[  13  ]") && matrixTag[3][1].equals("[  14  ]"))
        {
            stageFinish[0] = 10;//постановка на место чисел 6 и 10
            ask = "";
        }

        //серия5
        if(matrixTag[0][0].equals("[  01  ]") && matrixTag[0][1].equals("[  02  ]") &&
                matrixTag[0][2].equals("[  03  ]") && matrixTag[0][3].equals("[  04  ]") &&
                matrixTag[1][0].equals("[  05  ]") && matrixTag[2][0].equals("[  09  ]") &&
                matrixTag[3][0].equals("[  13  ]") && matrixTag[3][1].equals("[  14  ]") &&
                matrixTag[1][1].equals("[  06  ]") && matrixTag[2][1].equals("[  10  ]"))
        {
            stageFinish[0] = 11;//завершение
            ask = "";
        }




        System.out.println(stageFinish[0]+" "+ask+" "+jobFinish[0]+" "+stagePermutation[0]+" "+ searchStep[0]);



        /**
         *
         * ПОИСКОВАЯ ЧАСТЬ КОДА
         * серия1
         */
        if( stageFinish[0] >= 0 && stageFinish[0] <= 3 && jobFinish[0] == false)
        {//ПОИСКОВАЯ ЧАСТЬ КОДА серия1
            System.out.println("asking1");
            //Down
            if(  searchStep[0] >= 1 && searchStep[0] <= 3 )
            {
                if(matrixTag[newY][newX-1].equals(ask) || matrixTag[newY-1][newX].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY-1][newX];
                    matrixTag[newY-1][newX] = "[         ]";
                }
/*
                if(searchStep[0] == 1)
                {

                }

                if(searchStep[0] == 2 || searchStep[0] == 3)
                {
                    if(matrixTag[newY][newX-1].equals(ask) || matrixTag[newY-1][newX].equals(ask))
                    {
                        jobFinish[0] = true;
                    }
                    else
                    {
                        matrixTag[newY][newX] = matrixTag[newY-1][newX];
                        matrixTag[newY-1][newX] = "[         ]";
                    }
                }

*/

            }

            //Right
            if(  searchStep[0] >= 4 && searchStep[0] <= 5 || searchStep[0] >= 9 && searchStep[0] <= 10 ||
                    searchStep[0] >= 14 && searchStep[0] <= 15 || searchStep[0] >= 19 && searchStep[0] <= 20)
            {
                if(matrixTag[newY][newX-1].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY][newX-1];
                    matrixTag[newY][newX-1] = "[         ]";
                }

            }

            //Left
            if(  searchStep[0] >= 6 && searchStep[0] <= 7 || searchStep[0] >= 11 && searchStep[0] <= 12 ||
                    searchStep[0] >= 16 && searchStep[0] <= 17 || searchStep[0] >= 21 && searchStep[0] <= 22)
            {
                if(matrixTag[newY][newX-1].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY][newX+1];
                    matrixTag[newY][newX+1] = "[         ]";
                }
            }

            //Up
            if(  searchStep[0] == 8 || searchStep[0] == 13 ||  searchStep[0] == 18)
            {
                if(matrixTag[newY][newX-1].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY+1][newX];
                    matrixTag[newY+1][newX] = "[         ]";
                }
            }
        }  //закрытие: ПОИСКОВАЯ ЧАСТЬ КОДА серия1




        /**
         *
         * ИСПОЛНИТЕЛЬНАЯ ЧАСТЬ КОДА
         * серия1
         */
        //если произошла сработка в поисковой части кода
        if( stageFinish[0] >= 0 && stageFinish[0] <= 3 && jobFinish[0] == true)
        {//ИСПОЛНИТЕЛЬНАЯ ЧАСТЬ КОДА серия1
            /**
             * перестановка числа в крайнюю правую позицию
             */
            if(stagePermutation[0] == 0)
            {//перестановка числа в крайнюю правую позицию


                if(newX != 3)
                {//позиция 1
                    if(matrixTag[newY][newX+1].equals(ask))
                    {
                        if(newX + 1 == 3)
                        {
                            stagePermutation[0] = 1;
                        }
                        else
                        {
                            if(newY != 3)
                            {//Up
                                matrixTag[newY][newX] = matrixTag[newY+1][newX];
                                matrixTag[newY+1][newX] = "[         ]";
                            }
                            else
                            {//Down
                                matrixTag[newY][newX] = matrixTag[newY-1][newX];
                                matrixTag[newY-1][newX] = "[         ]";
                            }
                        }

                    }
                }

                if(newX != 3)
                {//позиция 2
                    if(newY != 3)
                    {
                        if(matrixTag[newY+1][newX+1].equals(ask))
                        {
                            if(newX+1 == 3)
                            {
                                stagePermutation[0] = 1;
                            }
                            else
                            {//Left
                                matrixTag[newY][newX] = matrixTag[newY][newX+1];
                                matrixTag[newY][newX+1] = "[         ]";
                            }
                        }
                    }
                    if(newY != 0)
                    {
                        if(matrixTag[newY-1][newX+1].equals(ask))
                        {
                            if(newX+1 == 3)
                            {
                                stagePermutation[0] = 1;
                            }
                            else
                            {//Left
                                matrixTag[newY][newX] = matrixTag[newY][newX+1];
                                matrixTag[newY][newX+1] = "[         ]";
                            }
                        }
                    }
                }

                if(newY != 3)
                {//позиция 3
                    if(matrixTag[newY+1][newX].equals(ask))
                    {
                        if(newX == 3)
                        {
                            stagePermutation[0] = 1;
                        }
                        else
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }
                    }
                }
                if(newY != 0)
                {
                    if(matrixTag[newY-1][newX].equals(ask))
                    {
                        if(newX == 3)
                        {
                            stagePermutation[0] = 1;
                        }
                        else
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }
                    }
                }

                if(newY != 3)
                {//позиция 4
                    if(newX != 0)
                    {
                        if(matrixTag[newY+1][newX-1].equals(ask))
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }
                    }
                }
                if(newY != 0)
                {
                    if(newX != 0)
                    {
                        if(matrixTag[newY-1][newX-1].equals(ask))
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }
                    }
                }

                if(newX != 0)
                {//позиция 5
                    if(matrixTag[newY][newX-1].equals(ask))
                    {//Right
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
                    }
                }
            }

            /**
             * перестановка числа в нужную строку
             */
            if(stagePermutation[0] == 1)
            {//перестановка числа в нужную строку
                if(newY != 0 )
                {//позиция 1
                    if(matrixTag[newY-1][newX].equals(ask))
                    {
                        //вариант совпадения строки
                        if( (stageFinish[0] == 0 && newY-1 == 0) || (stageFinish[0] == 1 && newY-1 == 1) ||
                                (stageFinish[0] == 2 && newY-1 == 0) || (stageFinish[0] == 3 && newY-1 == 2) )
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if( (stageFinish[0] == 0 && newY-1 > 0) || (stageFinish[0] == 1 && newY-1 > 1) ||
                                (stageFinish[0] == 2 && newY-1 > 0) || (stageFinish[0] == 3 && newY-1 > 2) )
                        {//Right
                            matrixTag[newY][newX] = matrixTag[newY][newX-1];
                            matrixTag[newY][newX-1] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if( (stageFinish[0] == 0 && newY-1 < 0) || (stageFinish[0] == 1 && newY-1 < 1) ||
                                (stageFinish[0] == 2 && newY-1 < 0) || (stageFinish[0] == 3 && newY-1 < 2) )
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }
                    }
                }

                if(newY != 0 && newX != 3)
                {//позиция 2
                    if(matrixTag[newY-1][newX+1].equals(ask))
                    {
                        //вариант совпадения строки
                        if( (stageFinish[0] == 0 && newY-1 == 0) || (stageFinish[0] == 1 && newY-1 == 1) ||
                                (stageFinish[0] == 2 && newY-1 == 0) || (stageFinish[0] == 3 && newY-1 == 2) )
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if( (stageFinish[0] == 0 && newY-1 > 0) || (stageFinish[0] == 1 && newY-1 > 1) ||
                                (stageFinish[0] == 2 && newY-1 > 0) || (stageFinish[0] == 3 && newY-1 > 2) )
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if( (stageFinish[0] == 0 && newY-1 < 0) || (stageFinish[0] == 1 && newY-1 < 1) ||
                                (stageFinish[0] == 2 && newY-1 < 0) || (stageFinish[0] == 3 && newY-1 < 2) )
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }
                    }
                }

                if(newX != 3)
                {//позиция 3
                    if(matrixTag[newY][newX+1].equals(ask))
                    {
                        //вариант совпадения строки
                        if( (stageFinish[0] == 0 && newY == 0) || (stageFinish[0] == 1 && newY == 1) ||
                                (stageFinish[0] == 2 && newY == 0) || (stageFinish[0] == 3 && newY == 2) )
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if( (stageFinish[0] == 0 && newY > 0) || (stageFinish[0] == 1 && newY > 1) ||
                                (stageFinish[0] == 2 && newY > 0) || (stageFinish[0] == 3 && newY > 2) )
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if( (stageFinish[0] == 0 && newY < 0) || (stageFinish[0] == 1 && newY < 1) ||
                                (stageFinish[0] == 2 && newY < 0) || (stageFinish[0] == 3 && newY < 2) )
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }
                    }
                }

                if(newX != 3 && newY != 3)
                {//позиция 4
                    if(matrixTag[newY+1][newX+1].equals(ask))
                    {
                        //вариант совпадения строки
                        if( (stageFinish[0] == 0 && newY+1 == 0) || (stageFinish[0] == 1 && newY+1 == 1) ||
                                (stageFinish[0] == 2 && newY+1 == 0) || (stageFinish[0] == 3 && newY+1 == 2) )
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        else if( (stageFinish[0] == 0 && newY+1 > 0) || (stageFinish[0] == 1 && newY+1 > 1) ||
                                (stageFinish[0] == 2 && newY+1 > 0) || (stageFinish[0] == 3 && newY+1 > 2) )
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        else if( (stageFinish[0] == 0 && newY+1 < 0) || (stageFinish[0] == 1 && newY+1 < 1) ||
                                (stageFinish[0] == 2 && newY+1 < 0) || (stageFinish[0] == 3 && newY+1 < 2) )
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }
                    }
                }

                if(newY != 3)
                {//позиция 5
                    if(matrixTag[newY+1][newX].equals(ask))
                    {
                        //вариант совпадения строки
                        if( (stageFinish[0] == 0 && newY+1 == 0) || (stageFinish[0] == 1 && newY+1 == 1) ||
                                (stageFinish[0] == 2 && newY+1 == 0) || (stageFinish[0] == 3 && newY+1 == 2) )
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if( (stageFinish[0] == 0 && newY+1 > 0) || (stageFinish[0] == 1 && newY+1 > 1) ||
                                (stageFinish[0] == 2 && newY+1 > 0) || (stageFinish[0] == 3 && newY+1 > 2) )
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if( (stageFinish[0] == 0 && newY+1 < 0) || (stageFinish[0] == 1 && newY+1 < 1) ||
                                (stageFinish[0] == 2 && newY+1 < 0) || (stageFinish[0] == 3 && newY+1 < 2) )
                        {//Right
                            matrixTag[newY][newX] = matrixTag[newY][newX-1];
                            matrixTag[newY][newX-1] = "[         ]";
                        }
                    }
                }
            }

            /**
             * перестановка числа в крайнюю левую позицию(за исключением четверки)
             */
            if(stagePermutation[0] == 2 && (stageFinish[0] == 0 || stageFinish[0] == 1 ||
                    stageFinish[0] == 2 || stageFinish[0] == 3) )
            {//перестановка числа в крайнюю левую позицию(за исключением четверки)
                if(newY != 3)
                {//внеплановая позиция 1
                    if(newX != 0 && matrixTag[newY+1][newX].equals(ask))
                    {//Right
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
                    }
                }

                if(newY != 3 && newX != 3)
                {//внеплановая позиция 2
                    if(matrixTag[newY+1][newX+1].equals(ask))
                    {//Up
                        matrixTag[newY][newX] = matrixTag[newY+1][newX];
                        matrixTag[newY+1][newX] = "[         ]";
                    }
                }


                if(newX != 0)
                {//позиция 1
                    if(newY != 3 && matrixTag[newY][newX-1].equals(ask))
                    {//Up
                        matrixTag[newY][newX] = matrixTag[newY+1][newX];
                        matrixTag[newY+1][newX] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX-1 == 0) ||
                                (stageFinish[0] == 2 &&  newX-1 == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newY != 0 && newX != 0)
                {//позиция 2
                    if(matrixTag[newY-1][newX-1].equals(ask))
                    {//Right
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX-1 == 0) ||
                                (stageFinish[0] == 2 &&  newX-1 == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newY != 0)
                {//позиция 3
                    if(newX != 0 && matrixTag[newY-1][newX].equals(ask))
                    {//Right
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX == 0) ||
                                (stageFinish[0] == 2 &&  newX == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newY != 0 && newX != 3)
                {//позиция 4
                    if(matrixTag[newY-1][newX+1].equals(ask))
                    {//Down
                        matrixTag[newY][newX] = matrixTag[newY-1][newX];
                        matrixTag[newY-1][newX] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX+1 == 0) ||
                                (stageFinish[0] == 2 &&  newX+1 == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newX != 3)
                {//позиция 5
                    if(matrixTag[newY][newX + 1].equals(ask))
                    {//Left
                        matrixTag[newY][newX] = matrixTag[newY][newX+1];
                        matrixTag[newY][newX+1] = "[         ]";

                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX == 0) ||
                                (stageFinish[0] == 2 &&  newX == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }
                    }
                }

            } //закрытие: перестановка числа в крайнюю левую позицию(за исключением четверки)

        } //закрытие: ИСПОЛНИТЕЛЬНАЯ ЧАСТЬ КОДА серия1

        if(stageFinish[0] == 4)
        {//двойная прокрутка для перехода от серии 1 к серии 2
            if(searchStep[0] == 1 || searchStep[0] == 2 || searchStep[0] == 3 ||
                    searchStep[0] == 13 || searchStep[0] == 14 || searchStep[0] == 15)
            {//Down
                matrixTag[newY][newX] = matrixTag[newY-1][newX];
                matrixTag[newY-1][newX] = "[         ]";
            }
            if(searchStep[0] == 4 || searchStep[0] == 5 || searchStep[0] == 6 ||
                    searchStep[0] == 16 || searchStep[0] == 17 || searchStep[0] == 18)
            {//Right
                matrixTag[newY][newX] = matrixTag[newY][newX-1];
                matrixTag[newY][newX-1] = "[         ]";
            }
            if(searchStep[0] == 7 || searchStep[0] == 8 || searchStep[0] == 9 ||
                    searchStep[0] == 19 || searchStep[0] == 20 || searchStep[0] == 21)
            {//Up
                matrixTag[newY][newX] = matrixTag[newY+1][newX];
                matrixTag[newY+1][newX] = "[         ]";
            }
            if(searchStep[0] == 10 || searchStep[0] == 11 || searchStep[0] == 12 ||
                    searchStep[0] == 22 || searchStep[0] == 23 || searchStep[0] == 24)
            {//Left
                matrixTag[newY][newX] = matrixTag[newY][newX+1];
                matrixTag[newY][newX+1] = "[         ]";
            }
            if( matrixTag[0][0].equals("[  01  ]") && matrixTag[0][1].equals("[  02  ]") &&
                    matrixTag[0][2].equals("[  03  ]") && matrixTag[0][3].equals("[  04  ]"))
            {
                searchStep[0] = -1;
            }
        }


        /**
         *
         * ПОИСКОВАЯ ЧАСТЬ КОДА
         * серия2
         */
        if( stageFinish[0] >= 5 && stageFinish[0] <= 7 && jobFinish[0] == false)
        {//ПОИСКОВАЯ ЧАСТЬ КОДА серия2
            System.out.println("asking2");
            //Down
            if(  searchStep[0] >= 1 && searchStep[0] <= 2 )
            {
                if(matrixTag[newY][newX-1].equals(ask) || matrixTag[newY-1][newX].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY-1][newX];
                    matrixTag[newY-1][newX] = "[         ]";
                }
            }

            //Right
            if(  searchStep[0] >= 3 && searchStep[0] <= 4 || searchStep[0] >= 8 && searchStep[0] <= 9 ||
                    searchStep[0] >= 13 && searchStep[0] <= 14)
            {
                if(matrixTag[newY][newX-1].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY][newX-1];
                    matrixTag[newY][newX-1] = "[         ]";
                }

            }

            //Left
            if(  searchStep[0] >= 5 && searchStep[0] <= 6 || searchStep[0] >= 10 && searchStep[0] <= 11 ||
                    searchStep[0] >= 15 && searchStep[0] <= 16)
            {
                if(matrixTag[newY][newX-1].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY][newX+1];
                    matrixTag[newY][newX+1] = "[         ]";
                }
            }

            //Up
            if(  searchStep[0] == 7 || searchStep[0] == 12)
            {
                if(matrixTag[newY][newX-1].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY+1][newX];
                    matrixTag[newY+1][newX] = "[         ]";
                }
            }
        }  //закрытие: ПОИСКОВАЯ ЧАСТЬ КОДА серия2

        /**
         *
         * ИСПОЛНИТЕЛЬНАЯ ЧАСТЬ КОДА
         * серия2
         */
        //если произошла сработка в поисковой части кода
        if( stageFinish[0] >= 5 && stageFinish[0] <= 7 && jobFinish[0] == true)
        {//ИСПОЛНИТЕЛЬНАЯ ЧАСТЬ КОДА серия2
            /**
             * перестановка числа в крайнюю правую позицию
             */
            if(stagePermutation[0] == 0)
            {//перестановка числа в крайнюю правую позицию


                if(newX != 3)
                {//позиция 1
                    if(matrixTag[newY][newX+1].equals(ask))
                    {
                        if(newX + 1 == 3)
                        {
                            stagePermutation[0] = 1;
                        }
                        else
                        {
                            if(newY != 3)
                            {//Up
                                matrixTag[newY][newX] = matrixTag[newY+1][newX];
                                matrixTag[newY+1][newX] = "[         ]";
                            }
                            else
                            {//Down
                                matrixTag[newY][newX] = matrixTag[newY-1][newX];
                                matrixTag[newY-1][newX] = "[         ]";
                            }
                        }

                    }
                }

                if(newX != 3)
                {//позиция 2
                    if(newY != 3)
                    {
                        if(matrixTag[newY+1][newX+1].equals(ask))
                        {
                            if(newX+1 == 3)
                            {
                                stagePermutation[0] = 1;
                            }
                            else
                            {//Left
                                matrixTag[newY][newX] = matrixTag[newY][newX+1];
                                matrixTag[newY][newX+1] = "[         ]";
                            }
                        }
                    }
                    if(newY != 0)
                    {
                        if(matrixTag[newY-1][newX+1].equals(ask))
                        {
                            if(newX+1 == 3)
                            {
                                stagePermutation[0] = 1;
                            }
                            else
                            {//Left
                                matrixTag[newY][newX] = matrixTag[newY][newX+1];
                                matrixTag[newY][newX+1] = "[         ]";
                            }
                        }
                    }
                }

                if(newY != 3)
                {//позиция 3
                    if(matrixTag[newY+1][newX].equals(ask))
                    {
                        if(newX == 3)
                        {
                            stagePermutation[0] = 1;
                        }
                        else
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }
                    }
                }
                if(newY != 0)
                {
                    if(matrixTag[newY-1][newX].equals(ask))
                    {
                        if(newX == 3)
                        {
                            stagePermutation[0] = 1;
                        }
                        else
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }
                    }
                }

                if(newY != 3)
                {//позиция 4
                    if(newX != 0)
                    {
                        if(matrixTag[newY+1][newX-1].equals(ask))
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }
                    }
                }
                if(newY != 0)
                {
                    if(newX != 0)
                    {
                        if(matrixTag[newY-1][newX-1].equals(ask))
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }
                    }
                }

                if(newX != 0)
                {//позиция 5
                    if(matrixTag[newY][newX-1].equals(ask))
                    {//Right
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
                    }
                }
            }

            /**
             * перестановка числа в нужную строку
             */
            if(stagePermutation[0] == 1)
            {//перестановка числа в нужную строку
                if(newY != 0 )
                {//позиция 1
                    if(matrixTag[newY-1][newX].equals(ask))
                    {
                        //вариант совпадения строки
                        if(newY - 1 == 1)
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if(newY-1 > 1)
                        {//Right
                            matrixTag[newY][newX] = matrixTag[newY][newX-1];
                            matrixTag[newY][newX-1] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if(newY-1 < 1)
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }
                    }
                }

                if(newY != 0 && newX != 3)
                {//позиция 2
                    if(matrixTag[newY-1][newX+1].equals(ask))
                    {
                        //вариант совпадения строки
                        if(newY-1 == 1)
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if(newY-1 > 1)
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if(newY-1 < 1)
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }
                    }
                }

                if(newX != 3)
                {//позиция 3
                    if(matrixTag[newY][newX+1].equals(ask))
                    {
                        //вариант совпадения строки
                        if(newY == 1)
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if(newY > 1)
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if(newY < 1)
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }
                    }
                }

                if(newX != 3 && newY != 3)
                {//позиция 4
                    if(matrixTag[newY+1][newX+1].equals(ask))
                    {
                        //вариант совпадения строки
                        if(newY+1 == 1)
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        else if(newY+1 > 1)
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        else if(newY+1 < 1)
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }
                    }
                }

                if(newY != 3)
                {//позиция 5
                    if(matrixTag[newY+1][newX].equals(ask))
                    {
                        //вариант совпадения строки
                        if(newY+1 == 1)
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if(newY+1 > 1)
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if(newY+1 < 1)
                        {//Right
                            matrixTag[newY][newX] = matrixTag[newY][newX-1];
                            matrixTag[newY][newX-1] = "[         ]";
                        }
                    }
                }
            }

            /**
             * перестановка числа в левую позицию
             */
            if(stagePermutation[0] == 2 && (stageFinish[0] == 5 || stageFinish[0] == 6 ||
                    stageFinish[0] == 7) )
            {//перестановка числа в крайнюю левую позицию
                if(newY != 3)
                {//внеплановая позиция 1
                    if(newX != 0 && matrixTag[newY+1][newX].equals(ask))
                    {//Right
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
                    }
                }

                if(newY != 3 && newX != 3)
                {//внеплановая позиция 2
                    if(matrixTag[newY+1][newX+1].equals(ask))
                    {//Up
                        matrixTag[newY][newX] = matrixTag[newY+1][newX];
                        matrixTag[newY+1][newX] = "[         ]";
                    }
                }


                if(newX != 0)
                {//позиция 1
                    if(newY != 3 && matrixTag[newY][newX-1].equals(ask))
                    {//Up
                        matrixTag[newY][newX] = matrixTag[newY+1][newX];
                        matrixTag[newY+1][newX] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX-1 == 0) ||
                                (stageFinish[0] == 2 &&  newX-1 == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newY != 0 && newX != 0)
                {//позиция 2
                    if(matrixTag[newY-1][newX-1].equals(ask))
                    {//Right
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX-1 == 0) ||
                                (stageFinish[0] == 2 &&  newX-1 == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newY != 0)
                {//позиция 3
                    if(newX != 0 && matrixTag[newY-1][newX].equals(ask))
                    {//Right
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX == 0) ||
                                (stageFinish[0] == 2 &&  newX == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newY != 0 && newX != 3)
                {//позиция 4
                    if(matrixTag[newY-1][newX+1].equals(ask))
                    {//Down
                        matrixTag[newY][newX] = matrixTag[newY-1][newX];
                        matrixTag[newY-1][newX] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX+1 == 0) ||
                                (stageFinish[0] == 2 &&  newX+1 == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newX != 3)
                {//позиция 5
                    if(matrixTag[newY][newX + 1].equals(ask))
                    {//Left
                        matrixTag[newY][newX] = matrixTag[newY][newX+1];
                        matrixTag[newY][newX+1] = "[         ]";

                        if( (stageFinish[0] == 5 &&  newX == 0) || (stageFinish[0] == 6 &&  newX == 1) ||
                                (stageFinish[0] == 7 &&  newX == 2) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }
                    }
                }

            } //закрытие: перестановка числа в левую позицию

        } //закрытие: ИСПОЛНИТЕЛЬНАЯ ЧАСТЬ КОДА серия2

        if(stageFinish[0] == 8)
        {//двойная прокрутка для перехода от серии 2 к серии 3
            if(searchStep[0] == 1 || searchStep[0] == 2 || searchStep[0] == 3 ||
                    searchStep[0] == 11 || searchStep[0] == 12 || searchStep[0] == 13)
            {//Right
                matrixTag[newY][newX] = matrixTag[newY][newX-1];
                matrixTag[newY][newX-1] = "[         ]";
            }
            if(searchStep[0] == 4 || searchStep[0] == 5 ||
                    searchStep[0] == 14 || searchStep[0] == 15)
            {//Down
                matrixTag[newY][newX] = matrixTag[newY-1][newX];
                matrixTag[newY-1][newX] = "[         ]";
            }
            if(searchStep[0] == 6 || searchStep[0] == 7 || searchStep[0] == 8 ||
                    searchStep[0] == 16 || searchStep[0] == 17 || searchStep[0] == 18)
            {//Left
                matrixTag[newY][newX] = matrixTag[newY][newX+1];
                matrixTag[newY][newX+1] = "[         ]";
            }
            if(searchStep[0] == 9 || searchStep[0] == 10 ||
                    searchStep[0] == 19 || searchStep[0] == 20)
            {//Up
                matrixTag[newY][newX] = matrixTag[newY+1][newX];
                matrixTag[newY+1][newX] = "[         ]";
            }

            if( matrixTag[0][0].equals("[  01  ]") && matrixTag[0][1].equals("[  02  ]") &&
                    matrixTag[0][2].equals("[  03  ]") && matrixTag[0][3].equals("[  04  ]") &&
                    matrixTag[1][0].equals("[  05  ]") && matrixTag[2][0].equals("[  09  ]") &&
                    matrixTag[3][0].equals("[  13  ]")
            )
            {
                searchStep[0] = -1;
            }
        }

        /**
         *
         * ПОИСКОВАЯ ЧАСТЬ КОДА
         * серия3
         */
        if( stageFinish[0] == 9 && jobFinish[0] == false)
        {//ПОИСКОВАЯ ЧАСТЬ КОДА серия3
            System.out.println("asking3");
            //Down
            if(  searchStep[0] >= 1 && searchStep[0] <= 2 )
            {
                if(matrixTag[newY][newX-1].equals(ask) || matrixTag[newY-1][newX].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY-1][newX];
                    matrixTag[newY-1][newX] = "[         ]";
                }
            }

            //Right
            if( searchStep[0] == 3 || searchStep[0] == 6 || searchStep[0] == 9)
            {
                if(matrixTag[newY][newX-1].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY][newX-1];
                    matrixTag[newY][newX-1] = "[         ]";
                }

            }

            //Left
            if(  searchStep[0] == 4 || searchStep[0] == 7 || searchStep[0] == 10)
            {
                if(matrixTag[newY][newX-1].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY][newX+1];
                    matrixTag[newY][newX+1] = "[         ]";
                }
            }

            //Up
            if(  searchStep[0] == 5 || searchStep[0] == 8 )
            {
                if(matrixTag[newY][newX-1].equals(ask))
                {
                    jobFinish[0] = true;
                }
                else
                {
                    matrixTag[newY][newX] = matrixTag[newY+1][newX];
                    matrixTag[newY+1][newX] = "[         ]";
                }
            }
        }  //закрытие: ПОИСКОВАЯ ЧАСТЬ КОДА серия2

        /**
         *
         * ИСПОЛНИТЕЛЬНАЯ ЧАСТЬ КОДА
         * серия3
         */
        //если произошла сработка в поисковой части кода
        if( stageFinish[0] == 9 && jobFinish[0] == true)
        {//ИСПОЛНИТЕЛЬНАЯ ЧАСТЬ КОДА серия2
            /**
             * перестановка числа в крайнюю правую позицию
             */
            if(stagePermutation[0] == 0)
            {//перестановка числа в крайнюю правую позицию


                if(newX != 3)
                {//позиция 1
                    if(matrixTag[newY][newX+1].equals(ask))
                    {
                        if(newX + 1 == 3)
                        {
                            stagePermutation[0] = 1;
                        }
                        else
                        {
                            if(newY != 3)
                            {//Up
                                matrixTag[newY][newX] = matrixTag[newY+1][newX];
                                matrixTag[newY+1][newX] = "[         ]";
                            }
                            else
                            {//Down
                                matrixTag[newY][newX] = matrixTag[newY-1][newX];
                                matrixTag[newY-1][newX] = "[         ]";
                            }
                        }

                    }
                }

                if(newX != 3)
                {//позиция 2
                    if(newY != 3)
                    {
                        if(matrixTag[newY+1][newX+1].equals(ask))
                        {
                            if(newX+1 == 3)
                            {
                                stagePermutation[0] = 1;
                            }
                            else
                            {//Left
                                matrixTag[newY][newX] = matrixTag[newY][newX+1];
                                matrixTag[newY][newX+1] = "[         ]";
                            }
                        }
                    }
                    if(newY != 0)
                    {
                        if(matrixTag[newY-1][newX+1].equals(ask))
                        {
                            if(newX+1 == 3)
                            {
                                stagePermutation[0] = 1;
                            }
                            else
                            {//Left
                                matrixTag[newY][newX] = matrixTag[newY][newX+1];
                                matrixTag[newY][newX+1] = "[         ]";
                            }
                        }
                    }
                }

                if(newY != 3)
                {//позиция 3
                    if(matrixTag[newY+1][newX].equals(ask))
                    {
                        if(newX == 3)
                        {
                            stagePermutation[0] = 1;
                        }
                        else
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }
                    }
                }
                if(newY != 0)
                {
                    if(matrixTag[newY-1][newX].equals(ask))
                    {
                        if(newX == 3)
                        {
                            stagePermutation[0] = 1;
                        }
                        else
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }
                    }
                }

                if(newY != 3)
                {//позиция 4
                    if(newX != 0)
                    {
                        if(matrixTag[newY+1][newX-1].equals(ask))
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }
                    }
                }
                if(newY != 0)
                {
                    if(newX != 0)
                    {
                        if(matrixTag[newY-1][newX-1].equals(ask))
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }
                    }
                }

                if(newX != 0)
                {//позиция 5
                    if(matrixTag[newY][newX-1].equals(ask))
                    {//Right
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
                    }
                }
            }

            /**
             * перестановка числа в нужную строку
             */
            if(stagePermutation[0] == 1)
            {//перестановка числа в нужную строку
                if(newY != 0 )
                {//позиция 1
                    if(matrixTag[newY-1][newX].equals(ask))
                    {
                        //вариант совпадения строки
                        if(newY - 1 == 3)
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if(newY-1 > 3)
                        {//Right
                            matrixTag[newY][newX] = matrixTag[newY][newX-1];
                            matrixTag[newY][newX-1] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if(newY-1 < 3)
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }
                    }
                }

                if(newY != 0 && newX != 3)
                {//позиция 2
                    if(matrixTag[newY-1][newX+1].equals(ask))
                    {
                        //вариант совпадения строки
                        if(newY-1 == 3)
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if(newY-1 > 3)
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if(newY-1 < 3)
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }
                    }
                }

                if(newX != 3)
                {//позиция 3
                    if(matrixTag[newY][newX+1].equals(ask))
                    {
                        //вариант совпадения строки
                        if(newY == 3)
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if(newY > 3)
                        {//Down
                            matrixTag[newY][newX] = matrixTag[newY-1][newX];
                            matrixTag[newY-1][newX] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if(newY < 3)
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }
                    }
                }

                if(newX != 3 && newY != 3)
                {//позиция 4
                    if(matrixTag[newY+1][newX+1].equals(ask))
                    {
                        //вариант совпадения строки
                        if(newY+1 == 3)
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        else if(newY+1 > 3)
                        {//Left
                            matrixTag[newY][newX] = matrixTag[newY][newX+1];
                            matrixTag[newY][newX+1] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        else if(newY+1 < 3)
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }
                    }
                }

                if(newY != 3)
                {//позиция 5
                    if(matrixTag[newY+1][newX].equals(ask))
                    {
                        //вариант совпадения строки
                        if(newY+1 == 3)
                        {
                            stagePermutation[0] = 2;
                        }

                        //вариант строки числа ниже нужного
                        if(newY+1 > 3)
                        {//Up
                            matrixTag[newY][newX] = matrixTag[newY+1][newX];
                            matrixTag[newY+1][newX] = "[         ]";
                        }

                        //вариант строки числа выше нужного
                        if(newY+1 < 3)
                        {//Right
                            matrixTag[newY][newX] = matrixTag[newY][newX-1];
                            matrixTag[newY][newX-1] = "[         ]";
                        }
                    }
                }
            }

            /**
             * перестановка числа в позицию matrixTag[3][1]
             */
            if( stagePermutation[0] == 2 && stageFinish[0] == 9 )
            {//перестановка числа в позицию matrixTag[3][1]
                if(newX != 0)
                {//позиция 1
                    if(newY != 0 && matrixTag[newY][newX-1].equals(ask))
                    {//Down
                        matrixTag[newY][newX] = matrixTag[newY-1][newX];
                        matrixTag[newY-1][newX] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX-1 == 0) ||
                                (stageFinish[0] == 2 &&  newX-1 == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newY != 3 && newX != 0)
                {//позиция 2
                    if(matrixTag[newY+1][newX-1].equals(ask))
                    {//Right
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX-1 == 0) ||
                                (stageFinish[0] == 2 &&  newX-1 == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newY != 3)
                {//позиция 3
                    if(newX != 0 && matrixTag[newY+1][newX].equals(ask))
                    {//Right
                        matrixTag[newY][newX] = matrixTag[newY][newX-1];
                        matrixTag[newY][newX-1] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX == 0) ||
                                (stageFinish[0] == 2 &&  newX == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newY != 3 && newX != 3)
                {//позиция 4
                    if(matrixTag[newY+1][newX+1].equals(ask))
                    {//Up
                        matrixTag[newY][newX] = matrixTag[newY+1][newX];
                        matrixTag[newY+1][newX] = "[         ]";
/*
                        if( ((stageFinish[0] == 0 || stageFinish[0] == 1 || stageFinish[0] == 3) && newX+1 == 0) ||
                                (stageFinish[0] == 2 &&  newX+1 == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }

 */
                    }
                }

                if(newX != 3)
                {//позиция 5
                    if(matrixTag[newY][newX + 1].equals(ask))
                    {//Left
                        matrixTag[newY][newX] = matrixTag[newY][newX+1];
                        matrixTag[newY][newX+1] = "[         ]";

                        if( (stageFinish[0] == 9 &&  newX == 1) )
                        {
                            stagePermutation[0] = 0;
                            jobFinish[0] = false;
                            searchStep[0] = -1;
                        }
                    }
                }

            } //закрытие: перестановка числа в позицию matrixTag[3][1]

        } //закрытие: ИСПОЛНИТЕЛЬНАЯ ЧАСТЬ КОДА серия3



        /**
         *
         * ИСПОЛНИТЕЛЬНАЯ ЧАСТЬ КОДА
         * серия4
         */
        if(stageFinish[0] == 10)
        {
            boolean check4 = true;
            //проверка на потребность в изменениях
            if( (newY == 1 && newX == 2 &&
                    matrixTag[1][1].equals("[  10  ]") && matrixTag[2][2].equals("[  06  ]") ) ||
                (newY == 1 && newX == 2 &&
                    matrixTag[2][2].equals("[  10  ]") && matrixTag[2][3].equals("[  06  ]") ) ||
                (newY == 1 && newX == 2 &&
                    matrixTag[3][2].equals("[  10  ]") && matrixTag[2][1].equals("[  06  ]") )  )
            {//Up
                matrixTag[newY][newX] = matrixTag[newY+1][newX];
                matrixTag[newY+1][newX] = "[         ]";
                check4 = false;
            }
            if( (newY == 2 && newX == 3 &&
                    matrixTag[1][3].equals("[  10  ]") && matrixTag[2][2].equals("[  06  ]") ) ||
                (newY == 2 && newX == 3 &&
                    matrixTag[3][2].equals("[  10  ]") && matrixTag[2][1].equals("[  06  ]") )  )
            {//Right
                matrixTag[newY][newX] = matrixTag[newY][newX-1];
                matrixTag[newY][newX-1] = "[         ]";
                check4 = false;
            }
            if( newY == 2 && newX == 2 &&
                    matrixTag[1][2].equals("[  10  ]") && matrixTag[2][1].equals("[  06  ]"))
            {//Down
                matrixTag[newY][newX] = matrixTag[newY-1][newX];
                matrixTag[newY-1][newX] = "[         ]";
                check4 = false;
            }
            if( (newY == 2 && newX == 2 &&
                    matrixTag[3][2].equals("[  10  ]") && matrixTag[2][3].equals("[  06  ]") ) ||
                (newY == 2 && newX == 2 &&
                    matrixTag[2][3].equals("[  10  ]") && matrixTag[1][3].equals("[  06  ]") )  )
            {//Left
                matrixTag[newY][newX] = matrixTag[newY][newX+1];
                matrixTag[newY][newX+1] = "[         ]";
                check4 = false;
            }

            if(check4)
            {//ход передвижений
                if( (newY == 3 && newX == 3) || (newY == 2 && newX == 3) )
                {//Down
                    matrixTag[newY][newX] = matrixTag[newY-1][newX];
                    matrixTag[newY-1][newX] = "[         ]";
                }
                if( (newY == 1 && newX == 3) || (newY == 1 && newX == 2) )
                {//Right
                    matrixTag[newY][newX] = matrixTag[newY][newX-1];
                    matrixTag[newY][newX-1] = "[         ]";
                }
                if( (newY == 1 && newX == 1) || (newY == 2 && newX == 2) )
                {//Up
                    matrixTag[newY][newX] = matrixTag[newY+1][newX];
                    matrixTag[newY+1][newX] = "[         ]";
                }
                if( (newY == 2 && newX == 1) || (newY == 3 && newX == 2) )
                {//Left
                    matrixTag[newY][newX] = matrixTag[newY][newX+1];
                    matrixTag[newY][newX+1] = "[         ]";
                }

            }

            if(matrixTag[0][0].equals("[  01  ]") && matrixTag[0][1].equals("[  02  ]") &&
                    matrixTag[0][2].equals("[  03  ]") && matrixTag[0][3].equals("[  04  ]") &&
                    matrixTag[1][0].equals("[  05  ]") && matrixTag[2][0].equals("[  09  ]") &&
                    matrixTag[3][0].equals("[  13  ]") && matrixTag[3][1].equals("[  14  ]") &&
                    matrixTag[1][1].equals("[  06  ]") && matrixTag[2][1].equals("[  10  ]"))
            {
                stagePermutation[0] = 0;
                jobFinish[0] = false;
                searchStep[0] = -1;
            }
        }

        /**
         *
         * ИСПОЛНИТЕЛЬНАЯ ЧАСТЬ КОДА
         * серия5
         */
        if(stageFinish[0] == 11)
        {
            boolean check5 = true;
            //проверка на потребность в изменениях
            if( newY == 2 && newX == 2 &&
                 (
                    ( matrixTag[2][3].equals("[  07  ]") && matrixTag[1][2].equals("[  08  ]") ) ||
                    ( matrixTag[2][3].equals("[  08  ]") && matrixTag[1][2].equals("[  12  ]") ) ||
                    ( matrixTag[2][3].equals("[  11  ]") && matrixTag[1][2].equals("[  07  ]") ) ||
                    ( matrixTag[2][3].equals("[  12  ]") && matrixTag[1][2].equals("[  15  ]") ) ||
                    ( matrixTag[2][3].equals("[  15  ]") && matrixTag[1][2].equals("[  11  ]") )
                 )
            )
            {//Left
                matrixTag[newY][newX] = matrixTag[newY][newX+1];
                matrixTag[newY][newX+1] = "[         ]";
                check5 = false;
            }

            if(check5)
            {//ход передвижений
                if( (newY == 3 && newX == 3) || (newY == 2 && newX == 3) )
                {//Down
                    matrixTag[newY][newX] = matrixTag[newY-1][newX];
                    matrixTag[newY-1][newX] = "[         ]";
                }
                if( newY == 1 && newX == 3 )
                {//Right
                    matrixTag[newY][newX] = matrixTag[newY][newX-1];
                    matrixTag[newY][newX-1] = "[         ]";
                }
                if( (newY == 1 && newX == 2) || (newY == 2 && newX == 2) )
                {//Up
                    matrixTag[newY][newX] = matrixTag[newY+1][newX];
                    matrixTag[newY+1][newX] = "[         ]";
                }
                if( newY == 3 && newX == 2 )
                {//Left
                    matrixTag[newY][newX] = matrixTag[newY][newX+1];
                    matrixTag[newY][newX+1] = "[         ]";
                }
            }
        }

    } //закрытие: public void autoComp
} //закрытие: public class AutoCompleter