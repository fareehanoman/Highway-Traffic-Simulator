package MVC;

import java.util.StringTokenizer;

public class ReadFile {

    public void main(String[] args) {
        readFile();
    }

    private void readFile() {
        MyReader mr = new MyReader("src/readfile/params");

        int lanes = next(mr);
        Globals.setNumLanes(lanes);
        int arrival = next(mr);
        Globals.setCarsArriving(arrival);
        mr.close();

        System.out.println("Globals = " + Globals.output());
    }

    int next(MyReader mr) {
        String s = mr.giveMeTheNextLine();
        StringTokenizer st = new StringTokenizer(s);
        return Integer.parseInt(st.nextToken());
    }

}
