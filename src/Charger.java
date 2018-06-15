/**
 * Created by Noy on 5/20/2018.
 */
public interface Charger {
    public void saveToDB (String type, Object o);
    public void deleteFromDB (String type, int ID);
    public void updateDB(String type, int id, Object New);

}
