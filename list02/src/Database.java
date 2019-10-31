import java.util.ArrayList;

public class Database {
    ArrayList<Client> clientArrayList;

    public Database() {
        clientArrayList= new ArrayList<>();
    }

    public ArrayList<Client> getClientArrayList() {
        return clientArrayList;
    }
    public String getClientPesel(int i){
        return clientArrayList.get(i).getPesel();
    }
    public Client getClient(int i){
        return clientArrayList.get(i);
    }
    public void setClientArrayList(ArrayList<Client> clientArrayList) {
        this.clientArrayList = clientArrayList;
    }
}
