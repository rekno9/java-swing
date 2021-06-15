package db.veiksmai;

import db.entities.Vartotojas;

import java.sql.*;

public class DuombazesVeiksmai
{
    public static Connection sukurtiDuombaze() throws SQLException
    {
        String dbServeris = "jdbc:mysql://localhost:3306/";
        String dbPav = "gui_app_db";
        String dbLogin = "root";
        String dbPsw = "";
        return DriverManager.getConnection(dbServeris + dbPav, dbLogin, dbPsw);
    }


    /**
     * Patikrina ar gautas vartotojas yra duomenų bazėje ir ar jo įvestas (programoje) slaptažodis atitinka tą, esantį duomenų bazėje
     * @param jungtis - Jungties objektas į duomenų bazę
     * @param v1 - gaunamas vartotojas, kurio ieškosime duomenų bazėje ir lyginsime ar juo duomenys sutampa
     * @return - grąžina 1, jeigu sutampa; grąžina 2, jeigu tokio vartotojo nėra; grąžina 3, jeigu netinka slaptažodis
     * @throws SQLException
     */
    public static int palygintiVartDuomenis(Connection jungtis, Vartotojas v1) throws SQLException
    {
        String sqlRastiVart = "SELECT * FROM vartotojai WHERE login=?";

        PreparedStatement prepSt = jungtis.prepareStatement(sqlRastiVart);
        prepSt.setString(1, v1.getLogin());
        ResultSet gautiVartotojai = prepSt.executeQuery();

        int kiekVartotoju = 0;
        Vartotojas v2 = new Vartotojas();
        while (gautiVartotojai.next())
        {
            v2.setLogin(gautiVartotojai.getString("login"));
            v2.setPsw(gautiVartotojai.getString("psw"));
            kiekVartotoju++;
        }


        if (kiekVartotoju > 0)
        {
            if (v2.getPsw().equals(v1.getPsw()))
            {
                System.out.println("viskas teisingai, prisijungete");
                return 1;
            }
            else
            {
                System.out.println("netinka psw");
                return 3;
            }
        }
        else
        {
            System.out.println("Nera tokio vartotojo");
            return 2;
        }
    }

    /*  uzsakymo table
    *   imones_pav
    *   uzsakymo_data
    *   uzsakymo_info
    *
    *   id - auto increment
    *   statusas - default 1 = active po uzsakymo ivygdymo nustatomas 0 -
    * */

    public static int PridetiUzsakyma(Connection jungtis, String imonesPav, String uzsakymoData, String uzsakymoInfo)
                                        throws SQLException{

        String sqlPridetiUzsakyma = "INSERT INTO uzsakymai (imones_pav, uzsakymo_data, uzsakymo_info) " +
                                    "VALUES (?, ?, ?)";
        PreparedStatement prepSt = jungtis.prepareStatement(sqlPridetiUzsakyma);
        prepSt.setString(1, imonesPav);
        prepSt.setString(2, uzsakymoData);
        prepSt.setString(3, uzsakymoInfo);
        prepSt.executeUpdate();

        return 1;//1 pavyko
    }
}