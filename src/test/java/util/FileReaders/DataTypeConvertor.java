package util.FileReaders;

public class DataTypeConvertor {

    public static void main(String[] args) {
        // Test Function
        System.out.println("OutPut Value" +  getTimeinMinutes("30 min"));
    }


    public static int getTimeinMinutes(String getTime) {
        int totalmin = 0;
        String processText = getTime;
/*
        //String s = "00 hr 30 min";

        if(!getTime.contains("hr")){
            processText = getTime.concat("00 hr"+getTime);

        }
*/
        //get time unit
        String value2 = processText.replaceAll("\\d", "");

        String[] parts;

        String hr = null;
        String min = null;
        if (value2.contains("hr")) {
            parts = processText.split("hr");
            hr = parts[0];

        }

        if (value2.contains("hr") && value2.contains("min")) {
            parts = processText.split("hr");
            hr = parts[0];
            processText = parts[1];
            //System.out.println("value2:"+ value2);
        }

        if (processText.contains("min")) {
            parts = processText.split("min");
            min = parts[0];

        }

        try {
            if (hr!=null){
                totalmin  = (Integer.parseInt(hr.trim()) * 60) + Integer.parseInt(min.trim());
            }
            else {
                totalmin = Integer.parseInt(min.trim());
            }

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        // System.out.println("HR:" + hr);
        // System.out.println("MIN:" + min);

        return totalmin;
    }

}


