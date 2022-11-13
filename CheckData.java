import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;

    public class CheckData {
        public static void checkData (String []data){
            checkDataLength(data);
            checkDMY(data[3]);
            checkNumberTel(data[4]);
            checkSex(data[5]);
    
        }
        
        
        public static void checkDataLength (String data[]){
            int l = data.length;
            if (l> Config.getArrLength())
                throw new ArrayIndexOutOfBoundsException("Введены лишние данные");
            if (l< Config.getArrLength()) 
                throw new IncompletenessOfDataException("Данные неполные");
        }
        public static void checkDMY(String dmy){
    
            String temp[] = dmy.split(Pattern.quote("."));
            if (!(temp.length==3) ||!(temp[0].length()==2) ||(!(temp[1].length()==2)||(!(temp[2].length()==4)))) 
                throw new NumberFormatException("Неправильный формат даты");
            
                int day = 0; 
                int month = 0; 
                int year = 0;
                try {
                    day = Integer.parseInt(temp[0]);
                    month = Integer.parseInt(temp[1]);
                    year = Integer.parseInt(temp[2]);
                    }
                catch (NumberFormatException Nfe){
                    System.out.println("Формат даты некорректный");
                    Nfe.printStackTrace();
                }
            if ((day<1)||(day>31)) throw new RuntimeException("День в дате не соответствует");
            if ((month<1)||(month>12)) throw new RuntimeException("Такого месяца нет");
            if (year<1900) throw new RuntimeErrorException(null, "Проверьте год рождения");
        }
    
        public static void checkNumberTel (String tel){
            int num = 0;
            try {
                num = Integer.parseInt(tel);
            }
            catch (NumberFormatException Nfe){
                System.out.println("Не корректно введен номер телефона. Он должен состоять только из цифр");
                Nfe.printStackTrace();
            }
            if (num<0) throw new RuntimeException("Отрицательные числа в телефонном номере не вводятся");
        }
        public static void checkSex(String s){
            if( (!s.equals("f"))&& (!s.equals("m")))
                throw new RuntimeException("Для выбора пола нужно было ввести f или m");
        }
    }
