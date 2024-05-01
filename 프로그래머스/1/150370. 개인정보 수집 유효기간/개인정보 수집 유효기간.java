import java.util.*;
import java.text.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws Exception{
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms){
            String[] tmp = term.split(" ");
            String type = tmp[0];
            int day = Integer.parseInt(tmp[1]) * 28;
            map.put(type,day);
        }
        

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date todayDate = dateFormat.parse(today);
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i<privacies.length; i++){
            String[] tmp = privacies[i].split(" ");
            String date = tmp[0];
            int days = map.get(tmp[1]);
            String tmpDate = AddDate(date,days-1);
            Date compare = dateFormat.parse(tmpDate);
            if(compare.before(todayDate)){
                arr.add(i+1);
            }
            
        }
        answer = arr.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    private static String AddDate(String today, int days) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date date = dateFormat.parse(today);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int totalDays = cal.get(Calendar.DATE) + days;
        int newYear = cal.get(Calendar.YEAR);
        int newMonth = cal.get(Calendar.MONTH);
        int newDay;

        while (totalDays > 28) {
            totalDays -= 28;
            newMonth++;
            if (newMonth > 12) {
                newMonth = 1;
                newYear++;
            }
        }
        newDay = totalDays;

        cal.set(Calendar.YEAR, newYear);
        cal.set(Calendar.MONTH, newMonth); 
        cal.set(Calendar.DATE, newDay);

        return dateFormat.format(cal.getTime());
    }
}