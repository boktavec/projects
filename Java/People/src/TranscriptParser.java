import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranscriptParser {
    public static void main(String[] args) {
        String transcript = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2000			Gender:	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	3.46
                """;
        String regex = """
                Student\\sNumber:\\s(?<studentNum>\\d{10}).* # Grab SN
                Grade:\\s+(?<grade>\\d{1,2}).* # Grab grade
                Birthdate:\\s+(?<birthMonth>\\d{2})/(?<birthDay>\\d{2})/(?<birthYear>\\d{4}).* # Grab birthdate
                Gender:\\s+(?<gender>\\w+\\b).* # Grab gender
                State\\sID:\\s+(?<stateID>\\d{10}).* # Grab SID
                Weighted\\)\\s+(?<weightedGPA>[\\d\\.+]\\b).* # Grab wGPA
                Unweighted\\)\\s(?<unweightedGPA>[\\d\\.+]\\b).* # Grab uwGPA

                """;

        Pattern pat = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS);
        Matcher mat = pat.matcher(transcript);

        if (mat.matches()) {
            System.out.printf("Student Number is: %s\n", mat.group("studentNum"));
            System.out.printf("Grade is: %s\n", mat.group("grade"));
            System.out.printf("Birth Month is: %s\n", mat.group("birthMonth"));
            System.out.printf("Birth Day is: %s\n", mat.group("birthDay"));
            System.out.printf("Birth Year is: %s\n", mat.group("birthYear"));
            System.out.printf("Gender is: %s\n", mat.group("gender"));
            System.out.printf("Weighted GPA is: %s\n", mat.group("weightedGPA"));
            System.out.printf("Unweighted GPA is: %s\n", mat.group("unweightedGPA"));

        }
    }
}
