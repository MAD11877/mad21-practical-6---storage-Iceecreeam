package sg.edu.np.mad.madpractical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


class DBHandler extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "User.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USER = "User";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "desciption";
    private static final String COLUMN_FOLLOWED = "followed";


    DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_USER +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_FOLLOWED + " BOOLEAN);";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, user.getName());
        cv.put(COLUMN_DESCRIPTION, user.getDescription());
        cv.put(COLUMN_FOLLOWED, user.getFollowed());

        db.insert(TABLE_USER,null, cv);
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> userList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        while (cursor.isAfterLast() == false)
        {

            User u = new User();
            u.setId(Integer.parseInt(cursor.getString(0)));
            u.setName(cursor.getString(1));
            u.setDescription(cursor.getString(2));
            Boolean b = true;
            if (cursor.getString(3).equals("0")) {
                b = false;
            }
            u.setFollowed(b);

            userList.add(u);
            cursor.moveToNext();
        }
        cursor.close();
        return userList;
    }

    public void updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID, user.getId());
        cv.put(COLUMN_NAME, user.getName());
        cv.put(COLUMN_DESCRIPTION, user.getDescription());
        cv.put(COLUMN_FOLLOWED, user.getFollowed());

        db.update(TABLE_USER, cv, "id = ?", new String[]{String.valueOf(user.getId())});
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
