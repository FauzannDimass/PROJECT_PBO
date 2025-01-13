abstract class Member {
    private int memberId;
    private String name;
    private String role;
    private Team team;

    public Member(int memberId, String name, String role) {
        this.memberId = memberId;
        this.name = name;
        this.role = role;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "Member [ID: " + memberId + ", Name: " + name + ", Role: " + role + "]";
    }
}
