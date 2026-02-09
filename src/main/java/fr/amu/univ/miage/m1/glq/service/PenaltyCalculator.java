package fr.amu.univ.miage.m1.glq.service;

import fr.amu.univ.miage.m1.glq.model.Member;

public class PenaltyCalculator {
    // Configuration en dur
    static final double PENALTY_RATE_PER_DAY = 0.50;

    public PenaltyCalculator() {
    }

    /**
     * Calcule la pénalité de retard.
     */
    public double calculatePenalty(Member member, int daysOverdue) {
        if (daysOverdue <= 0) {
            return 0;
        }

        double rate;
        double maxPenalty;

        if (member.getMemberType().equals("STUDENT")) {
            rate = 0.25; // Tarif réduit pour les étudiants
            maxPenalty = 10.0;
        } else if (member.getMemberType().equals("TEACHER")) {
            rate = 0.0; // Pas de pénalité pour les enseignants
            maxPenalty = 0.0;
        } else if (member.getMemberType().equals("STAFF")) {
            rate = 0.25;
            maxPenalty = 15.0;
        } else {
            rate = 0.50; // Tarif plein pour les externes
            maxPenalty = 25.0;
        }

        double penalty = daysOverdue * rate;
        return Math.min(penalty, maxPenalty);
    }
}