package com.swajan.bharat.nits.ramjas.constants;

public enum CourseCode {


    BSCBOTANY("B.Sc (Hons.) Botany","BT"),
    BSCCHEMISTRY("B.Sc. (Hons.) Chemistry","CH"),
    BCOM("B. Com (Hons.)","BM"),
    BAECO("B.A. (Hons.) Economics","EC"),
    BAENG("B.A. (Hons.) English","EN"),
    BAHIN("B.A. (Hons.) Hindi","HN"),
    BAHIS("B.A. (Hons.) History","HS"),
    BSCMATH("B.Sc. (Hons.) Mathematics","MT"),
    BSCPHY("B.Sc. (Hons.) Physics","PY"),
    BAMUSIC("B.A. (Hons.) Music","MU"),
    BAPOLSC("B.A. (Hons.) Political Science","PL"),
    BA("B.A. Programme","BA"),
    BSCP("B.Sc. Programme","BP"),
    BASANS("B.A. (Hons.) Sanskrit","SN"),
    BSCSTATS("B.Sc. (Hons.) Statistics","ST"),
    BSCLIFESC("B.Sc. (Prog.) Life Science","LS"),
    BSCZOO("B.Sc (Hons.) Zoology","ZO"),
    BCOMP(" B. Com Programme","BC"),
    BSCPHYSICALSC("B.Sc. (Prog.) Physical Science","PS"),
    BAHMUSIC("B.A. (Hons.) Hindustani Music","BM"),
    BAPMUSIC("B.A. (Hons.) Percussion Music","PM"),
    MAENG("MA English","ME"),
    MAHIN("MA Hindi","MH"),
    MASANS("MA Sanskrit","MS"),
    MAECO("MA Economics","MN"),
    MAHIS("MA History","MI"),
    MAPOLSC("MA Political Science","MP"),
    MAMATHS("MA Maths","AM"),
    MSCMATH("M.Sc. Maths","SM"),
    MSCSTATS("M.Sc. Statistics","SS"),
    MAOR("M.A. Operation Research","OR"),
    MCOM("M.Com.","CO"),
    MAMUSIC("M.A. Music","MU"),
    MSCPHY("M.Sc. Physics","PY"),
    MACHEM("M.Sc. Chemistry","CH"),
    MABOT("M.A. Botany","BT"),
    MSCZOO("M.Sc. Zoology","ZO"),
    MPHIL("M.A. Philosophy","ML"),

    OTHER("Other","OH");
    public final String courseName;
    public final String courseCode;
    private CourseCode(String courseName,String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }
}
