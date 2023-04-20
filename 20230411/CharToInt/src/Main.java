import java.sql.*;

public class Main {
    public static void main(String[] args) {
        SQLData db = new SQLData() {
            @Override
            public String getSQLTypeName() throws SQLException {
                return null;
            }

            @Override
            public void readSQL(SQLInput stream, String typeName) throws SQLException {

            }

            @Override
            public void writeSQL(SQLOutput stream) throws SQLException {

            }
        };
    }
}