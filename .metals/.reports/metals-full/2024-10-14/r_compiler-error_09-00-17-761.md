file://<WORKSPACE>/JEDI-FlipFit-Java-POS/src/com/flipkart/dao/GymDao.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/JEDI-FlipFit-Java-POS/src/com/flipkart/dao/GymDao.java
text:
```scala
package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GymDao{

    public static DbUtils dbUtils = new DbUtils();

    public void addGym(Gym gym) {

        String sql = "INSERT INTO Gym (gymId, gymName, address, city, gymOwnerId, listed) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)) {

            pstmt.setString(1, gym.getGymId());
            pstmt.setString(2, gym.getGymName());
            pstmt.setString(3, gym.getAddress());
            pstmt.setString(4, gym.getCity());
            pstmt.setString(5, gym.getGymOwnerID());
            pstmt.setBoolean(6, gym.getIsListed());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Gym> getGymCenters(String userId) {
        List<Gym> gymCenters = new ArrayList<>();
        String sql = "SELECT * FROM Gym WHERE gymOwnerID = ?";

        try (PreparedStatement statement = dbUtils.connection.prepareStatement(sql)) {

            statement.setString(1, userId); // Assuming user.getId() gives the gymOwnerID

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gymId = resultSet.getString("gymId");
                String gymName = resultSet.getString("gymName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String gymOwnerID = resultSet.getString("gymOwnerID");
                boolean listed = resultSet.getBoolean("listed");
                Gym gym = new Gym(gymId, gymName, address, city, gymOwnerID,listed);
                gymCenters.add(gym);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymCenters;
    }

    public List<Gym> getAllGymCenters() {
        List<Gym> gymCenters = new ArrayList<>();
        String sql = "SELECT * FROM Gym";

        try (PreparedStatement statement = dbUtils.connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gymId = resultSet.getString("gymId");
                String gymName = resultSet.getString("gymName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String gymOwnerID = resultSet.getString("gymOwnerID");
                boolean listed = resultSet.getBoolean("listed");
                Gym gym = new Gym(gymId, gymName, address, city, gymOwnerID,listed);
                gymCenters.add(gym);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymCenters;
    }


    public void listGym(String gymId) {

        String sql = "UPDATE Gym SET listed = 1 WHERE gymId = (?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)) {

            pstmt.setString(1, gymId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        System.out.println("Listed " + gymId);



    }

    public void unlistGym(String gymId) {

        String sql = "UPDATE Gym SET listed = 0 WHERE gymId = (?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)) {

            pstmt.setString(1, gymId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        System.out.println("UnListed " + gymId);



    }


//    public User validateUser(String username, String password) {
//        String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
//        try (PreparedStatement statement = dbUtils.connection.prepareStatement(sql)) {
//            statement.setString(1, username);
//            statement.setString(2, password);
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                return new User(rs.getString("userId"),rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getInt("age"), rs.getString("roleId"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public boolean updateUser(User user) {
//        String sql = "UPDATE user SET username = ?, password = ? WHERE userid = ?";
//        try (Connection conn = dbutils.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, user.getUsername());
//            ps.setString(2, user.getPassword());
//            ps.setString(3, user.getUserid());
//            return ps.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
}

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:28)
	scala.meta.internal.pc.SimpleCollector.<init>(PcCollector.scala:373)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:90)
	scala.meta.internal.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:117)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator