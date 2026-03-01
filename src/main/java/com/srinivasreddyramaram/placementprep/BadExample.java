package com.srinivasreddyramaram.placementprep;

/**
 * ============================================================
 *  BAD EXAMPLE — DO NOT USE THIS STYLE
 * ============================================================
 *
 *  This is what happens when a beginner puts EVERYTHING
 *  in one place — database logic, API calls, HTTP handling
 *  all mixed together in a single file.
 *
 *  Problems with this approach:
 *  - If the AI API changes tomorrow, you have to dig through
 *    HTTP code just to find the AI logic.
 *  - If the database changes, you risk breaking the API.
 *  - Nobody else on your team can understand or test this.
 *  - At Swiggy or Razorpay, code like this gets rejected
 *    in code review immediately.
 *
 *  This file exists only to show the contrast.
 *  The real project is in controller/ service/ repository/
 * ============================================================
 */
public class BadExample {

    // Imagine ALL of this crammed into a single method:
    //
    // public String doEverything(String topic) {
    //
    //     // DATABASE LOGIC mixed with...
    //     Connection conn = DriverManager.getConnection("jdbc:h2:mem:db");
    //     Statement stmt = conn.createStatement();
    //     stmt.execute("CREATE TABLE IF NOT EXISTS sessions (...)");
    //
    //     // ...AI API CALL mixed with...
    //     RestTemplate rt = new RestTemplate();
    //     String url = "https://generativelanguage.googleapis.com/...";
    //     Map body = Map.of("contents", List.of(...));
    //     Map response = rt.postForObject(url, body, Map.class);
    //
    //     // ...RESPONSE PARSING mixed with...
    //     String questions = ((Map)((List)response.get("candidates")).get(0))
    //                           .get("content").toString();
    //
    //     // ...SAVING TO DATABASE
    //     stmt.execute("INSERT INTO sessions VALUES ('" + topic + "', '" + questions + "')");
    //
    //     return questions;
    // }
    //
    // This works. But it's a nightmare to maintain, test, or extend.
    // NOW look at how the real project splits this into clean layers.
}
