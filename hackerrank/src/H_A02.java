import java.util.*;

/**
 * Created by hannahzhang on 16/5/8.
 */
public class H_A02 {

    public List<String> getDirectFriendsForUser(String user){
        return Collections.emptyList();
    }
    public List<String> getAttendedCoursesForUser(String user){
        return Collections.emptyList();

    }

    static class Course {
        String name;
        int count;
    }



    //first
    public List<String> getRankedCourses(String user) {
        Set<String> socialSet = new HashSet<String>();
        Set<String> userCourseSet = new HashSet<String>();
        userCourseSet.addAll(getAttendedCoursesForUser(user));
        Map<String, Course> courseMap = new HashMap<String, Course>();



        //find direct friend of user
        List<String> directFriend = getDirectFriendsForUser(user);
        socialSet.addAll(directFriend);

        //find direct friend  of direct friend
        for (String friend : directFriend) {
           socialSet.addAll(getDirectFriendsForUser(friend));
        }
        //find all courses for social set
        for (String friend : socialSet) {
            List<String> friendCourse = getAttendedCoursesForUser(friend);

            for (String course : friendCourse) {
                //only courses that not attended by current course will be added
                if(!userCourseSet.contains(course)) {
                    Course value  = courseMap.get(course);
                    if(value == null) {
                        value = new Course();
                        value.count = 1;
                        value.name  = course;
                        courseMap.put(course, value);
                    }else {
                        value.count = value.count + 1;
                        courseMap.put(course, value);
                    }
                }
            }
        }
        List<Course> courseList = new ArrayList<Course>();

        courseList.addAll(courseMap.values());

        Collections.sort(courseList, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.count - o2.count;
            }
        });

        List<String> result = new ArrayList<String>();
        for(Course course : courseList) {
            result.add(course.name);
        }

        return result;


    }


}
