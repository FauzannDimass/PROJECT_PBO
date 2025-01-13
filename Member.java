abstract class Member {
    private int memberId;
    private String name;
    private String role;

    public Member(int memberId, String name, String role) {
        this.memberId = memberId;
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Member [ID: " + memberId + ", Name: " + name + ", Role: " + role + "]";
    }
}
