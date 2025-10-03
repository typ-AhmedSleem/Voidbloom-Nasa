package com.typ.voidbloom.data.repo

import com.typ.voidbloom.shared.models.SpaceFact

object FactsRepository {

    private val spaceFacts = listOf(
        SpaceFact(
            category = "Human Health",
            title = "Bone Loss in Space",
            description = "Astronauts can lose 1–2% of their bone mass per month in microgravity — much faster than osteoporosis on Earth."
        ),
        SpaceFact(
            category = "Human Health",
            title = "Muscle Atrophy",
            description = "Muscles weaken quickly in space since they don’t work against gravity. Astronauts exercise ~2 hours daily to stay strong."
        ),
        SpaceFact(
            category = "Immune System",
            title = "Immune System Changes",
            description = "Spaceflight alters immune cell activity, making astronauts more vulnerable to infections."
        ),
        SpaceFact(
            category = "Plants & Life Support",
            title = "Plants Grow Differently",
            description = "Roots grow in random directions in space since they can’t sense 'down,' relying instead on light and water."
        ),
        SpaceFact(
            category = "Human Health",
            title = "Fluid Shift",
            description = "Astronauts’ faces look puffier in space because body fluids move upward without gravity pulling them down."
        ),
        SpaceFact(
            category = "Radiation",
            title = "Space Radiation",
            description = "Cosmic radiation in deep space can damage DNA and increase cancer risks, a key challenge for Mars missions."
        ),
        SpaceFact(
            category = "Microbes & Extremophiles",
            title = "Tardigrades in Space",
            description = "Tardigrades, or water bears, survived the vacuum of space, extreme radiation, and freezing temperatures."
        ),
        SpaceFact(
            category = "Regenerative Medicine",
            title = "Stem Cells in Space",
            description = "Stem cells behave differently in microgravity, which could lead to breakthroughs in regenerative medicine."
        ),
        SpaceFact(
            category = "Vision & Neuroscience",
            title = "Vision Issues",
            description = "Many astronauts develop blurry vision in space due to increased pressure on the eyes from fluid shifts."
        ),
        SpaceFact(
            category = "Genetics",
            title = "Gene Expression",
            description = "Space can switch certain genes on or off differently than on Earth, proving biology is highly space-responsive."
        ),
        SpaceFact(
            category = "Fun",
            title = "Astronaut Height Boost",
            description = "Astronauts grow up to 2 inches taller in space because their spines expand without gravity compressing them."
        ),
        SpaceFact(
            category = "Plants & Life Support",
            title = "Moon Farming",
            description = "Scientists have grown plants in lunar soil samples, paving the way for future moon gardens."
        ),
        SpaceFact(
            category = "Animal Models",
            title = "Space Snails & Balance",
            description = "Land snails in space adapted their sense of balance in microgravity, then relearned it on Earth."
        ),
        SpaceFact(
            category = "Animal Models",
            title = "Fruit Flies, the Tiny Astronauts",
            description = "Fruit flies were the first animals launched into space in 1947 — and are still studied today."
        ),
        SpaceFact(
            category = "Human Health",
            title = "Floating Hearts",
            description = "Astronauts’ hearts become about 10% rounder in microgravity compared to Earth."
        ),
        SpaceFact(
            category = "Fun",
            title = "Pizza in Orbit",
            description = "NASA has experimented with yeast in microgravity to explore how to bake food in space — pizza included!"
        ),
        SpaceFact(
            category = "Fun",
            title = "Cosmic 'Space Flu'",
            description = "Astronauts often feel stuffy in space because fluids shift toward their heads, like a permanent head cold."
        ),
        SpaceFact(
            category = "Plants & Life Support",
            title = "Greenhouses on Mars",
            description = "Plants recycle CO₂ into oxygen, making them essential for future Mars habitats."
        ),
        SpaceFact(
            category = "Microbes & Health",
            title = "Space Bacteria Tricksters",
            description = "Some bacteria become more dangerous in space, showing altered virulence in microgravity."
        ),
        SpaceFact(
            category = "Medicine",
            title = "Protein Folding in Space",
            description = "Microgravity changes protein folding, which could help design new medicines on Earth and in space."
        )
    )

    fun getAllSpaceFacts(): List<SpaceFact> {
        return spaceFacts
    }

}