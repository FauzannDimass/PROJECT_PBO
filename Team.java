import java.util.ArrayList;
import java.util.List;

class Team {
    private int teamId;
    private String namaTim;
    private List<Member> anggota;

    public Team(int teamId, String namaTim) {
        this.teamId = teamId;
        this.namaTim = namaTim;
        this.anggota = new ArrayList<>();
    }

    public void tambahAnggota(Member member) {
        anggota.add(member);
    }

    public void tampilkanAnggota() {
        System.out.println("Team: " + namaTim);
        for (Member member : anggota) {
            System.out.println(member);
        }
    }
}
