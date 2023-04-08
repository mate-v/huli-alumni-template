/*
Given a list of names, determine the number of names in that list for which a given query string is a prefix. The prefix must be at least 1 character less than the entire name string.

Example
names = ["jackson", "jacques", "jack"];
query = ["jack"];
The complete query string jack is a prefix of jackson but not of jacques or jack. The prefix cannot contain the entire name string, so jack does not qualify.
*/

    public static void main(String[] args) throws IOException {

        List<String> names = Arrays.asList("jackson", "jacques", "jack");
        List<String> query = Arrays.asList("jack", "jac", "jacq");
        //correct: 1, 3, 1

        System.out.println(findCompletePrefixes(names, query));

        List<String> names2 = Arrays.asList("a", "b", "ab", "aba", "bab", "baba", "bba");
        List<String> query2 = Arrays.asList("a", "b", "ab", "ba");
        //correct: 2, 3, 1, 2

        System.out.println(findCompletePrefixes(names2, query2));
    }

    public static List<Integer> findCompletePrefixes(List<String> names, List<String> query) {
        List<Integer> prefixNumberForEachQuery = new ArrayList<>();

        for (String qu : query) {
            int prefix = qu.length();
            int counter = 0;

            for (String name : names) {
                if ((name.length() > qu.length()) &&
                        (name.toLowerCase().substring(0, prefix).equals(qu.toLowerCase()))) {
                    counter++;
                }
            }

            prefixNumberForEachQuery.add(counter);
        }

        return prefixNumberForEachQuery;
    }
