package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ydurand
 */
public class RepresentationDao {
    
    /**
     * Extraction d'une representation, sur son identifiant
     * @param idRepresentation identifiant
     * @return objet Representation
     * @throws SQLException 
     */
    public static Representation selectOne(int idRepresentation) throws SQLException {
        Representation uneRepresentation = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM REPRESENTATION WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idRepresentation);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID");
            String date_representation = rs.getString("DATE_REPRESENTATION");
            String id_lieu = rs.getString("ID_LIEU");
            String id_groupe = rs.getString("ID_GROUPE");
            String heureDebut = rs.getString("HEURE_DEBUT");
            String heureFin = rs.getString("HEURE_FIN");
            uneRepresentation =  new Representation(id, date_representation, id_lieu, id_groupe, heureDebut, heureFin);
        }
        return uneRepresentation;
    }

    /**
     * Extraction de toutes les representations
     * @return collection de representation
     * @throws SQLException 
     */
    public static List<Representation> selectAll() throws SQLException {
        List<Representation> lesRepresentations = new ArrayList<Representation>();
        Representation uneRepresentation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM REPRESENTATION";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String date_representation = rs.getString("DATE_REPRESENTATION");
            String id_lieu = rs.getString("ID_LIEU");
            String id_groupe = rs.getString("ID_GROUPE");
            String heureDebut = rs.getString("HEURE_DEBUT");
            String heureFin = rs.getString("HEURE_FIN");
            uneRepresentation =  new Representation(id, date_representation, id_lieu, id_groupe, heureDebut, heureFin);
            lesRepresentations.add(uneRepresentation);
        }
        return lesRepresentations;
    }
}

/*          String nomLieu = rs.getString("NOM_LIEU");
            String nomGroupe = rs.getString("NOM_GROUPE");
            String heureDebut = rs.getString("HEURE_DEBUT");
            String heureFin = rs.getString("HEURE_FIN");
            uneRepresentation =  new Representation(id, nomLieu, nomGroupe, heureDebut, heureFin);*/