package com.example.a3;


import java.util.ArrayList;

public class Members {

    private ArrayList<Member> medlemmar;

    public ArrayList<Member> getMedlemmar() {
        return medlemmar;
    }

    public void setMedlemmar(ArrayList<Member> medlemmar) {
        this.medlemmar = medlemmar;
    }

    public class Member {
        private String epost;
        private String namn;
        private String svarade;

        public String getEpost() {
            return epost;
        }

        public void setEpost(String epost) {
            this.epost = epost;
        }

        public String getNamn() {
            return namn;
        }

        public void setNamn(String namn) {
            this.namn = namn;
        }

        public String getSvarade() {
            return svarade;
        }

        public void setSvarade(String svarade) {
            this.svarade = svarade;
        }
    }
}
