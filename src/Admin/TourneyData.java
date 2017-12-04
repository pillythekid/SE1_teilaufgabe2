package Admin;

import dbUtil.dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TourneyData {
    Connection connection;
    private int TourneyNR;

    int portNumber;

    TourneyData(int _TourneyNR) {
        TourneyNR = _TourneyNR;
        try {
            this.connection = dbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (this.connection == null) {
            System.exit(1);
        }
    }

    public boolean registerPlayer(int _mtrnr1, int _mtrnr2) {
        String insertSql = "INSERT INTO `tourney` (`gameNR`, `player1`, `player2`, `winner`, `turnsToWin`) VALUES (`" + TourneyNR + "`, `" + _mtrnr1 + "`, `" + _mtrnr2 + "`, NULL, NULL)";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(insertSql);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void feedMAP(int[] _A, int[] _B, int[] _C, int[] _D, int _x, int _y, int _player) {
        //map is already checked for rules in management and thus will feed the map now into the DBcontroller
        //here we break the Lists up and feed the fields one by one into the MAP table
        String insertSql1 = null;
        String insertSql2 = null;
        String insertSql3 = null;
        String insertSql4 = null;
        if (_player == 1) {
            try {
                insertSql1 = "INSERT INTO `MAP` (`gameNR`, `nr`, `A`, `B`, `C`, `D`, `E`, `F`, `G`, `H`) "
                        + "VALUES (`" + TourneyNR + "`, `" + 1 + "`, `" + _A[0] + "`, `" + _A[1] + "`, `" + _A[2] + "`, `" + _A[3] + "`, `" + _A[4] + "`, `" + _A[5] + "`, `" + _A[6] + "`, `" + _A[7] + "`)";
                insertSql2 = "INSERT INTO `MAP` (`gameNR`, `nr`, `A`, `B`, `C`, `D`, `E`, `F`, `G`, `H`) "
                        + "VALUES (`" + TourneyNR + "`, `" + 2 + "`, `" + _B[0] + "`, `" + _B[1] + "`, `" + _B[2] + "`, `" + _B[3] + "`, `" + _B[4] + "`, `" + _B[5] + "`, `" + _B[6] + "`, `" + _B[7] + "`)";
                insertSql3 = "INSERT INTO `MAP` (`gameNR`, `nr`, `A`, `B`, `C`, `D`, `E`, `F`, `G`, `H`) "
                        + "VALUES (`" + TourneyNR + "`, `" + 3 + "`, `" + _C[0] + "`, `" + _C[1] + "`, `" + _C[2] + "`, `" + _C[3] + "`, `" + _C[4] + "`, `" + _C[5] + "`, `" + _C[6] + "`, `" + _C[7] + "`)";
                insertSql4 = "INSERT INTO `MAP` (`gameNR`, `nr`, `A`, `B`, `C`, `D`, `E`, `F`, `G`, `H`) "
                        + "VALUES (`" + TourneyNR + "`, `" + 4 + "`, `" + _D[0] + "`, `" + _D[1] + "`, `" + _D[2] + "`, `" + _D[3] + "`, `" + _D[4] + "`, `" + _D[5] + "`, `" + _D[6] + "`, `" + _D[7] + "`)";
            } catch (Exception e) {
                System.err.println("Es wurden zu wenige Felder eingetragen." + e.getMessage());
            }
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(insertSql1);
                stmt.executeUpdate(insertSql2);
                stmt.executeUpdate(insertSql3);
                stmt.executeUpdate(insertSql4);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (_player == 2) {
            try {
                insertSql1 = "INSERT INTO `MAP` (`gameNR`, `nr`, `A`, `B`, `C`, `D`, `E`, `F`, `G`, `H`) "
                        + "VALUES (`" + TourneyNR + "`, `" + 5 + "`, `" + _A[0] + "`, `" + _A[1] + "`, `" + _A[2] + "`, `" + _A[3] + "`, `" + _A[4] + "`, `" + _A[5] + "`, `" + _A[6] + "`, `" + _A[7] + "`)";
                insertSql2 = "INSERT INTO `MAP` (`gameNR`, `nr`, `A`, `B`, `C`, `D`, `E`, `F`, `G`, `H`) "
                        + "VALUES (`" + TourneyNR + "`, `" + 6 + "`, `" + _B[0] + "`, `" + _B[1] + "`, `" + _B[2] + "`, `" + _B[3] + "`, `" + _B[4] + "`, `" + _B[5] + "`, `" + _B[6] + "`, `" + _B[7] + "`)";
                insertSql3 = "INSERT INTO `MAP` (`gameNR`, `nr`, `A`, `B`, `C`, `D`, `E`, `F`, `G`, `H`) "
                        + "VALUES (`" + TourneyNR + "`, `" + 7 + "`, `" + _C[0] + "`, `" + _C[1] + "`, `" + _C[2] + "`, `" + _C[3] + "`, `" + _C[4] + "`, `" + _C[5] + "`, `" + _C[6] + "`, `" + _C[7] + "`)";
                insertSql4 = "INSERT INTO `MAP` (`gameNR`, `nr`, `A`, `B`, `C`, `D`, `E`, `F`, `G`, `H`) "
                        + "VALUES (`" + TourneyNR + "`, `" + 8 + "`, `" + _D[0] + "`, `" + _D[1] + "`, `" + _D[2] + "`, `" + _D[3] + "`, `" + _D[4] + "`, `" + _D[5] + "`, `" + _D[6] + "`, `" + _D[7] + "`)";
            } catch (Exception e) {
                System.err.println("Es wurden zu wenige Felder eingetragen." + e.getMessage());
            }
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(insertSql1);
                stmt.executeUpdate(insertSql2);
                stmt.executeUpdate(insertSql3);
                stmt.executeUpdate(insertSql4);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("Spieler nicht erkannt.");
        }
    }
    public int feedLOG(int _x, int _y, int _turn) {
        int _event = 0;
        int _inventory = getLOG(false, _turn);
        if(_inventory == 0){
            _event = getPOS(_x, _y);
            if (_event == 3) _inventory = 1;
            if (_event == 0 || _event == 1 || _event == 2) _event = 0;
        }
        String insertSql = "INSERT INTO `LOG` (`gameNR`, `turn`, `player`, `position`, `inventory`) "
                        + "VALUES (`" + TourneyNR + "`, `" + _turn + "`, `" + (((_turn % 2) == 0) ? 2 : 1) + "`, `" + ((_x * 10) + _y) + "`, `"+_inventory+"`)";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(insertSql);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return _event;
    }
    public void feedPOS (int _x, int _y, int _value) {
        String point= null;
        switch (_x) {
            case 1:point="A";
                break;
            case 2:point="B";
                break;
            case 3:point="C";
                break;
            case 4:point="D";
                break;
            case 5:point="E";
                break;
            case 6:point="F";
                break;
            case 7:point="G";
                break;
            case 8:point="H";
                break;
        }
        int _field = getPOS(_x,_y);
        if ((_value==3 ||_value==4) && _field==1){
            String insertSql =
                    "UPDATE `MAP`"
                            +"SET `"+point+"` = `"+_value+"` WHERE `gameNR` == `"+TourneyNR+"` AND `nr` == `"+_y+"`";
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(insertSql);
            } catch(Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            try {
                if (_field != 1)
                    throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if (_field == 0 || _field ==2) {
                    System.out.println("Placement of field is not permitted.");
                }
                else {
                    System.out.println("Value incorrect");
                }
            }
        }
    }
    public List<Integer> getMAP(int _player){
        ArrayList<Integer> _map = new ArrayList<>();
        ResultSet rs = null;
        String getSql = null;
        if (_player==1) {
            getSql = "SELECT * FROM `MAP` WHERE WHERE `gameNR` == `"+TourneyNR+"` AND `nr` BETWEEN `5` AND `8`";
        } else if (_player==2) {
            getSql = "SELECT * FROM `MAP` WHERE WHERE `gameNR` == `"+TourneyNR+"` AND `nr` BETWEEN `1` AND `4`";
        }
        try (Statement stmt = connection.createStatement()) {
            rs = stmt.executeQuery(getSql);
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            assert rs != null;
            while(rs.next()) {
                _map.add(rs.getInt("A"));
                _map.add(rs.getInt("B"));
                _map.add(rs.getInt("C"));
                _map.add(rs.getInt("D"));
                _map.add(rs.getInt("E"));
                _map.add(rs.getInt("F"));
                _map.add(rs.getInt("G"));
                _map.add(rs.getInt("H"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  _map;
    }
    public int getLOG(boolean _log, int _turn){
        String getSql;
        int _value = 0;
        ResultSet rs;
        if (!_log) {
            getSql = "SELECT `inventory` FROM `LOG` WHERE `gameNR` == `"+TourneyNR+"` AND `player` == `"+((_turn%2)==0?2:1)+"` AND `turn` = (SELECT MAX(`turn`) FROM `LOG` WHERE `gameNR` == `"+TourneyNR+"` AND `player` == `"+((_turn%2)==0?2:1)+"`)";
        } else {
            getSql = "SELECT `position` FROM `LOG` WHERE `gameNR` == `"+TourneyNR+"` AND `player` == `"+((_turn%2)==0?2:1)+"` AND `turn` = (SELECT MAX(`turn`) FROM `LOG` WHERE `gameNR` == `"+TourneyNR+"` AND `player` == `"+((_turn%2)==0?2:1)+"`)";
        }
        try (Statement stmt = connection.createStatement()) {
            rs = stmt.executeQuery(getSql);
            _value = rs.getInt("inventory");
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return _value;
    }
    public int getPOS(int _x, int _y) {
        String _point = null;
        String getSql;
        ResultSet rs;
        switch (_x) {
            case 1:_point="A";
                break;
            case 2:_point="B";
                break;
            case 3:_point="C";
                break;
            case 4:_point="D";
                break;
            case 5:_point="E";
                break;
            case 6:_point="F";
                break;
            case 7:_point="G";
                break;
            case 8:_point="H";
                break;
        }
        int _field = 0;
            getSql = "SELECT `"+_point+"` FROM MAP WHERE `gameNR` == `"+TourneyNR+"` AND `nr` == `"+_y+"`";
        try (Statement stmt = connection.createStatement()) {
            rs = stmt.executeQuery(getSql);
            _field = rs.getInt(""+_point+"");
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return _field;
    }
}
