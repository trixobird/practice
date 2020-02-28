package vitamin;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Sort the columns of a csv-file
 *         You get a string with the content of a csv-file.
 *
 *         CSV Description:
 *         The columns are separated by commas (,).
 *         The rows are separated by a single newline (\n)
 *         The first line contains the names of the columns.
 *         A blank space counts as an empty string.
 *         Treat every value as a string.
 *         Your Task
 *         Write a method that sorts the columns by the names of the columns alphabetically, and case-insensitive.
 *
 *         Specification
 *         Challenge.sortCsvColumns(csvData)
 *         Takes comma separated values and sorts it alphabetically
 *
 *         Parameters
 *         csvData: String - Unsorted CSV
 *
 *         Return Value
 *         String - Sorted CSV
 *
 *         Example Input
 *         Raw Input:
 *
 *         Beth,Charles,Danielle,Adam,Eric\n
 *         17945,10091,10088,3907,10132\n
 *         2,12,13,48,11
 *         As a Table:
 *
 *         Beth	Charles	Danielle	Adam	Eric
 *         17945	10091	10088	3907	10132
 *         2	12	13	48	11
 *         Example Output
 *         Raw output:
 *
 *         Adam,Beth,Charles,Danielle,Eric\n
 *         3907,17945,10091,10088,10132\n
 *         48,2,12,13,11
 *         As a Table:
 */
class SortColumns {

    private SortColumns() {}

    public static String sortCsvColumns( String csv_data ) {
        String csvData = csv_data.replace(",,", ", ,");
        String[] rows = csvData.split("\n");

        String[] headers = rows[0].split(",");
        TreeMap<String, List<String>> data = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (String header : headers) {
            data.put(header, new ArrayList<>());
        }
        for (int i = 1; i < rows.length; i++) {
            String[] columns = rows[i].split(",");
            for (int j = 0; j < headers.length; j++) {
                if (j >= columns.length) {
                    data.get(headers[j]).add(" ");
                } else {
                    data.get(headers[j]).add(columns[j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(String.join(",", data.keySet()));
        sb.append("\n");

        for (int i = 0; i < rows.length - 1; i++) {
            int finalI = i;
            data.forEach((k, v) -> {
                sb.append(v.get(finalI));
                sb.append(",");
            });
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
