package amazon;

import java.util.*;

/**
 * Created by kenvi on 16/8/14.
 */
public class SocialNetworkTraversal {

    static class Course implements Comparable<Course> {
        String name;
        int attenders;

        @Override
        public int compareTo(Course o) {
            return (this.attenders - o.attenders);
        }
    }

    public List<String> getRankedCourses(String user) {
        List<String> friendList = new ArrayList<>();

        List<String> firstLevel = getDirectFriendsForUser(user) ;
        friendList.addAll(firstLevel);

        for (String firstLevelUser : firstLevel) {
            List<String> secondLevel = getDirectFriendsForUser(firstLevelUser);
            friendList.addAll(secondLevel);
        }

        Map<String,Integer> resultMap = new HashMap<>();

        for (String friend : friendList) { //C
            List<String> courseList = getAttendedCoursesForUser(friend); //M

            for (String course : courseList) {
                Integer value = resultMap.get(course);
                if(value == null) {
                    resultMap.put(course, 1);
                }else {
                    resultMap.put(course, value + 1);
                }
            }
        }

        for (String attendedCourse : getAttendedCoursesForUser(user)) {
            resultMap.remove(attendedCourse);
        }

        List<Course> courseList = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : resultMap.entrySet()) {
            Course course = new Course();
            course.name = entry.getKey();
            course.attenders = entry.getValue();

            courseList.add(course);
        }
        Collections.sort(courseList);
        //MlogM
        List<String> rankedList = new ArrayList<>();

        for (Course course : courseList) {
            rankedList.add(course.name);
        }
        return rankedList;

    }

    public List<String> getDirectFriendsForUser(String user){
        return Collections.emptyList();
    }
    public List<String> getAttendedCoursesForUser(String user) {
        return Collections.emptyList();
    }
}
