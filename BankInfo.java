public class BankInfo {

    private String accno;
    private String name;
    private String acc_type;
    private long balance;
    private String aadhar;
    private String password;

    public BankInfo(String accno, String name, String acc_type, long balance, String aadhar, String password) {
        this.accno = accno;
        this.name = name;
        this.acc_type = acc_type;
        this.balance = balance;
        this.aadhar = aadhar;
        this.password = password;
    }

    public String getAccno() {
        return accno;
    }

    public String getName() {
        return name;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }
    
    public String getAadhar() {
        return aadhar;
    }
}
