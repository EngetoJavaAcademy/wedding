package com.engeto.wedding.repository;


import com.engeto.wedding.model.Occurrence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class WeddingRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addNewWedding(Occurrence newOccurence){
        String date = new SimpleDateFormat("yyyy-MM-dd").format(newOccurence.getDateOfWedding());
        jdbcTemplate.execute("INSERT INTO Occurrence(DateOfWedding,Title,MaximalPrice) VALUES('" + date + "','" + newOccurence.getTitle() + " ', " + newOccurence.getMaximalPriceForGift() + " )");
    }

    public List<Occurrence> getAllOccurence() {
        return
                jdbcTemplate.query("SELECT * FROM Occurrence",
                        (rs, rowNum) -> {
                            return new Occurrence(rs.getInt("ID"),rs.getDate("dateOfWedding"),rs.getString("title"),rs.getInt("maximalPrice"));

                        }
                    );
    }

    public Occurrence getOneOccurrence(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Occurrence WHERE ID = ?", new Object[]{id}, (rs, rowNum) -> {
            return new Occurrence(
                    rs.getInt("ID"),
                    rs.getDate("dateOfWedding"),
                    rs.getString("title"),
                    rs.getInt("maximalPrice")
            );

        });
    }

    public void deleteWedding(Occurrence deleteOccurrence) {
        System.out.println(deleteOccurrence.getId());
        jdbcTemplate.execute("DELETE FROM Occurrence WHERE ID = " + deleteOccurrence.getId());
    }

    public Occurrence updateOneOccurrence(Occurrence occurrence) {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(occurrence.getDateOfWedding());

        jdbcTemplate.execute("UPDATE Occurrence" +
                " SET dateOfWedding = '" + date + "'," +
                "title = '" + occurrence.getTitle() + "'," +
                "maximalPrice = " + occurrence.getMaximalPriceForGift() +
                " WHERE ID =  " + occurrence.getId() + ";");
        return occurrence;
    }

}
