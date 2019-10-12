package ru.job4j.sort;


import java.util.*;
import java.util.regex.Pattern;

public class Departments {

    public void sort(List<Org> dep) {
        Collections.sort(dep);
    }

    public void sortDesc(List<Org> dep) {
        Collections.sort(dep, new Comparator<Departments.Org>() {
            @Override
            public int compare(Org o1, Org o2) {
                int result = 0;
                String[] nameThis = o1.name.replaceAll(Pattern.quote("\\"), "\\\\").split("\\\\");
                String[] nameO = o2.name.replaceAll(Pattern.quote("\\"), "\\\\").split("\\\\");
                int length = nameThis.length < nameO.length ? nameThis.length : nameO.length;
                int count = 0;
                while (count != length) {
                    if (CharSequence.compare(nameO[count], nameThis[count]) != 0) {
                        result = CharSequence.compare(nameO[count], nameThis[count]);
                        break;
                    }
                    count++;
                }
                if ((result == 0 && nameThis.length != nameO.length)) {
                    result = nameThis.length > nameO.length ? 1 : -1;
                }
                return result;
            }
        });
    }

    final static class Org implements Comparable<Org> {
        String name;

        public String getName() {
            return name;
        }

        public Org(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Org o) {
            int result = 0;
            String[] nameThis = this.name.replaceAll(Pattern.quote("\\"), "\\\\").split("\\\\");
            String[] nameO = o.name.replaceAll(Pattern.quote("\\"), "\\\\").split("\\\\");
            int length = nameThis.length < nameO.length ? nameThis.length : nameO.length;
            int count = 0;
            while (count != length) {
                if (CharSequence.compare(nameThis[count], nameO[count]) != 0) {
                    result = CharSequence.compare(nameThis[count], nameO[count]);
                    break;
                }
                count++;
            }
            if ((result == 0 && nameThis.length != nameO.length)) {
                result = nameThis.length > nameO.length ? 1 : -1;
            }
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Org org = (Org) o;
            return name.equals(org.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static List<Org> convert(List<Org> deps) {
        Set<Org> dep = new HashSet<>(deps);
        String separator = "\\";
        for (Org org : deps) {
            String name = org.getName();
            String[] strArr = name.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
            if (strArr.length > 1) {
                int i = strArr.length - 1;
                while (name.length() > 2 && i > 0) {
                    int i1 = name.length() - strArr[i--].length() - 1;
                    name = name.substring(0, i1);
                    dep.add(new Departments.Org(name));
                }
            }
        }
        return new ArrayList<>(dep);
    }
}
