package ru.job4j.sort;


import java.util.*;

public class Departments {

    public void sort(List<Org> dep) {
        Collections.sort(dep);
    }

    public void sortDesc(List<Org> dep) {
        Collections.sort(dep, new Comparator<Departments.Org>() {
            @Override
            public int compare(Org o1, Org o2) {
                int result = 0;
                int length = o1.names.length < o2.names.length ? o1.names.length : o2.names.length;
                int count = 0;
                while (count != length) {
                    if (CharSequence.compare(o2.names[count], o1.names[count]) != 0) {
                        result = CharSequence.compare(o2.names[count], o1.names[count]);
                        break;
                    }
                    count++;
                }
                if ((result == 0 && o1.names.length != o2.names.length)) {
                    result = o1.names.length > o2.names.length ? 1 : -1;
                }
                return result;
            }
        });
    }

    final static class Org implements Comparable<Org> {
        private String name;
        private String[] names;

        public String getName() {
            return name;
        }

        public Org(String name) {
            this.name = name;
            names = name.split("\\\\");
        }

        @Override
        public int compareTo(Org o) {
            int result = 0;
            int length = this.names.length < o.names.length ? this.names.length : o.names.length;
            int count = 0;
            while (count != length) {
                if (CharSequence.compare(this.names[count], o.names[count]) != 0) {
                    result = CharSequence.compare(this.names[count], o.names[count]);
                    break;
                }
                count++;
            }
            if ((result == 0 && this.names.length != o.names.length)) {
                result = this.names.length > o.names.length ? 1 : -1;
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
        for (Org org : deps) {
            String name = org.getName();
            if (org.names.length > 1) {
                int i = org.names.length - 1;
                while (name.length() > 2 && i > 0) {
                    int i1 = name.length() - org.names[i--].length() - 1;
                    name = name.substring(0, i1);
                    dep.add(new Departments.Org(name));
                }
            }
        }
        return new ArrayList<>(dep);
    }
}
