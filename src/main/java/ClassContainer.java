import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassContainer {
    Map<String, Class> map = new HashMap<>();

    public Map<String, Class> getMap() {
        return map;
    }



    public ClassContainer() {
    }

    @Override
    public String toString() {
        return "ClassContainer{" +
                "map=" + map +
                '}';
    }

    public void getInfos(){
        for (var c : map.entrySet()) {
            System.out.println(c.getKey());
        }
    }

    public void addClass(String s, double size, Class c, Integer id){
        Class newClass = new Class(s, size, id);
        newClass.setNameOfGroup(s);
        newClass.setMaxNumberOfStudents(size);
//        newClass.setStudentsList(c.getStudentsList());
        map.put(s, newClass);
    }

    public void removeClass(String s){
        System.out.println(map.values());
        map.remove(s);
    }

    public Class getClassByName(String s){
        System.out.println("start");
        for(String s0 : map.keySet()) {
//            System.out.println(s0);
            if (s.equals(s0)) {
                return map.get(s0);
            }
        }
        System.out.println("stop");

        return null;
    }

    public List<Class> findEmpty(){
        List<Class> emptyList = new ArrayList<>();
        for (Class c: map.values()) {
            if(c.getStudentsList().size() == 0){
                emptyList.add(c);
            }
        }
        return emptyList;
    }

    public void summary(){
        double currentSize = 0;
        for (Class c: map.values()) {
            currentSize = (c.getStudentsList().size() / c.getMaxNumberOfStudents()) * 100;
            System.out.println("Nazwa grupy: " + c.getNameOfGroup() + " zapelnienie: " + currentSize + " %");
        }
    }
}
