package com.typ.voidbloom.data.repo

import androidx.compose.ui.util.fastDistinctBy
import com.typ.voidbloom.shared.models.Publication
import com.typ.voidbloom.utils.millisNow
import kotlin.random.Random
import kotlin.time.ExperimentalTime

object PublicationsRepository {
    const val MAX_SUGGESTIONS_SIZE = 8

    private val publications = listOf(
        Publication(
            id = "PMC4136787",
            "Mice in Bion-M 1 space mission: training and selection",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4136787/"
        ),
        Publication(
            id = "PMC3630201",
            "Microgravity induces pelvic bone loss through osteoclastic activity, osteocytic osteolysis, and osteoblastic cell cycle inhibition by CDKN1a/p21",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3630201/"
        ),
        Publication(
            id = "PMC11988870",
            title = "Stem Cell Health and Tissue Regeneration in Microgravity",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11988870/"
        ),
        Publication(
            id = "PMC7998608",
            "Microgravity Reduces the Differentiation and Regenerative Potential of Embryonic Stem Cells",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7998608/"
        ),
        Publication(
            id = "PMC5587110",
            "Microgravity validation of a novel system for RNA isolation and multiplex quantitative real time PCR analysis of gene expression on the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5587110/"
        ),
        Publication(
            id = "PMC8396460",
            "Spaceflight Modulates the Expression of Key Oxidative Stress and Cell Cycle Related Genes in Heart",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8396460/"
        ),
        Publication(
            id = "PMC5666799",
            "Dose- and Ion-Dependent Effects in the Oxidative Stress Response to Space-Like Radiation Exposure in the Skeletal System",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5666799/"
        ),
        Publication(
            id = "PMC5460236",
            "From the bench to exploration medicine: NASA life sciences translational research for human exploration and habitation missions.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5460236/"
        ),
        Publication(
            id = "PMC6222041",
            "High-precision method for cyclic loading of small-animal vertebrae to assess bone quality.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6222041/"
        ),
        Publication(
            id = "PMC6813909",
            "Effects of ex vivo ionizing radiation on collagen structure and whole-bone mechanical properties of mouse vertebrae.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6813909/"
        ),
        Publication(
            id = "PMC4095884",
            "Absence of gamma-sarcoglycan alters the response of p70S6 kinase to mechanical perturbation in murine skeletal muscle",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4095884/"
        ),
        Publication(
            id = "PMC3040128",
            "AtRabD2b and AtRabD2c have overlapping functions in pollen development and pollen tube growth.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3040128/"
        ),
        Publication(
            id = "PMC3177255",
            "TNO1 is involved in salt tolerance and vacuolar trafficking in Arabidopsis.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3177255/"
        ),
        Publication(
            id = "PMC11500582",
            "Functional redundancy between trans-Golgi network SNARE family members in Arabidopsis thaliana.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11500582/"
        ),
        Publication(
            id = "PMC5387210",
            "Root growth movements: Waving and skewing.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5387210/"
        ),
        Publication(
            id = "PMC4642138",
            "Gravitropism and lateral root emergence are dependent on the trans-Golgi network protein TNO1",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4642138/"
        ),
        Publication(
            id = "PMC2915878",
            "The Drosophila SUN protein Spag4 cooperates with the coiled-coil protein Yuri Gagarin to maintain association of the basal body and spermatid nucleus.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2915878/"
        ),
        Publication(
            id = "PMC3901686",
            "Toll mediated infection response is altered by gravity and spaceflight in Drosophila",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3901686/"
        ),
        Publication(
            id = "PMC6985101",
            "Multi-omics analysis of multiple missions to space reveal a theme of lipid dysregulation in mouse liver",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6985101/"
        ),
        Publication(
            id = "PMC6387434",
            "GeneLab database analyses suggest long-term impact of space radiation on the cardiovascular system by the activation of FYN through reactive oxygen species.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6387434/"
        ),
        Publication(
            id = "PMC6371294",
            "FAIRness and usability for open-access omics data systems.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6371294/"
        ),
        Publication(
            id = "PMC7072278",
            "NASA GeneLab platform utilized for biological response to space radiation in animal models",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7072278/"
        ),
        Publication(
            id = "PMC8441986",
            "Circulating miRNA spaceflight signature reveals targets for countermeasure development",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8441986/"
        ),
        Publication(
            id = "PMC9400218",
            "Machine learning algorithm to characterize antimicrobial resistance associated with the International Space Station surface microbiome",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9400218/"
        ),
        Publication(
            id = "PMC9267413",
            "Extraterrestrial Gynecology: Could Spaceflight Increase the Risk of Developing Cancer in Female Astronauts? An Updated Review",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9267413/"
        ),
        Publication(
            id = "PMC9576569",
            "Muscle atrophy phenotype gene expression during spaceflight is linked to a metabolic crosstalk in both the liver and the muscle in mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9576569/"
        ),
        Publication(
            id = "PMC10789781",
            "Chromosomal positioning and epigenetic architecture influence DNA methylation patterns triggered by galactic cosmic radiation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10789781/"
        ),
        Publication(
            id = "PMC10772081",
            "A comprehensive SARS-CoV-2 and COVID-19 review, Part 2: Host extracellular to systemic effects of SARS-CoV-2 infection",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10772081/"
        ),
        Publication(
            id = "PMC11166946",
            "Aging and putative frailty biomarkers are altered by spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166946/"
        ),
        Publication(
            id = "PMC11166944",
            "Space radiation damage rescued by inhibition of key spaceflight associated miRNAs",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166944/"
        ),
        Publication(
            id = "PMC11166968",
            "Ethical considerations for the age of non-governmental space exploration",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166968/"
        ),
        Publication(
            id = "PMC7000411",
            "Innate immune responses of Drosophila melanogaster are altered by spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7000411/"
        ),
        Publication(
            id = "PMC7787258",
            "Prolonged Exposure to Microgravity Reduces Cardiac Contractility and Initiates Remodeling in Drosophila",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7787258/"
        ),
        Publication(
            id = "PMC8716943",
            "Regulation of plant gravity sensing and signaling by the actin cytoskeleton.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8716943/"
        ),
        Publication(
            id = "PMC4826010",
            "HLB1 Is a Tetratricopeptide Repeat Domain-Containing Protein That Operates at the Intersection of the Exocytic and Endocytic Pathways at the TGN/EE in Arabidopsis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4826010/"
        ),
        Publication(
            id = "PMC6048781",
            "ERULUS is a plasma membrane-localized receptor-like kinase that specifies root hair growth by maintaining tip-focused cytoplasmic calcium oscillations.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6048781/"
        ),
        Publication(
            id = "PMC7010715",
            "Brassinosteroids inhibit autotropic root straightening by modifying filamentous-actin organization and dynamics.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7010715/"
        ),
        Publication(
            id = "PMC7503278",
            "Cell type-specific imaging of calcium signaling in Arabidopsis thaliana seedling roots using GCaMP3.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7503278/"
        ),
        Publication(
            id = "PMC8364238",
            "Spatial and temporal localization of SPIRRIG and WAVE/SCAR reveal roles for these proteins in actin-mediated root hair development.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8364238/"
        ),
        Publication(
            id = "PMC11579474",
            "Microgravity Stress: Bone and Connective Tissue",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11579474/"
        ),
        Publication(
            id = "PMC2998437",
            "S. aureus MscL is a pentamer in vivo but of variable stoichiometries in vitro: implications for detergent-solubilized membrane proteins",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2998437/"
        ),
        Publication(
            id = "PMC3005423",
            "Manipulating the permeation of charged compounds through the MscL nanovalve.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3005423/"
        ),
        Publication(
            id = "PMC3190158",
            "The oligomeric state of the truncated mechanosensitive channel of large conductance shows no variance in vivo.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3190158/"
        ),
        Publication(
            id = "PMC3289768",
            "Three routes to modulate the pore size of the MscL channel/nanovalve",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3289768/"
        ),
        Publication(
            id = "PMC3508904",
            "The dynamics of protein-protein interactions between domains of MscL at the cytoplasmic-lipid interface",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3508904/"
        ),
        Publication(
            id = "PMC3430326",
            "The MscS and MscL families of mechanosensitive channels act as microbial emergency release valves",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3430326/"
        ),
        Publication(
            id = "PMC3593973",
            "Chimeras reveal a single lipid-interface residue that controls MscL channel kinetics as well as mechanosensitivity",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3593973/"
        ),
        Publication(
            id = "PMC5018776",
            "Evidence for extensive horizontal gene transfer from the draft genome of a tardigrade",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5018776/"
        ),
        Publication(
            id = "PMC4896697",
            "Reply to Bemm et al. and Arakawa: Identifying foreign genes in independent Hypsibius dujardini genome assemblies",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4896697/"
        ),
        Publication(
            id = "PMC11127935",
            "Tardigrades Use Intrinsically Disordered Proteins to Survive Desiccation.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11127935/"
        ),
        Publication(
            id = "PMC11831363",
            "Desiccation of Hypsibius exemplaris",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11831363/"
        ),
        Publication(
            id = "PMC11930778",
            "The biology of tardigrade disordered proteins in extreme stress tolerance.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11930778/"
        ),
        Publication(
            id = "PMC8816950",
            "Production of reactive oxygen species and involvement of bioprotectants during anhydrobiosis in the tardigrade Paramacrobiotus spatialis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8816950/"
        ),
        Publication(
            id = "PMC3774184",
            "Partial weight suspension: A novel murine model for investigating adaptation to reduced musculoskeletal loading.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3774184/"
        ),
        Publication(
            id = "PMC4118556",
            "Partial reductions in mechanical loading yield proportional changes in bone density, bone architecture, and muscle mass",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4118556/"
        ),
        Publication(
            id = "PMC4653813",
            "Spaceflight and hind limb unloading induce similar changes in electrical impedance characteristics of mouse gastrocnemius muscle",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4653813/"
        ),
        Publication(
            id = "PMC6915713",
            "Spaceflight Activates Lipotoxic Pathways in Mouse Liver",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6915713/"
        ),
        Publication(
            id = "PMC6124165",
            "Treatment with a soluble bone morphogenetic protein type 1A receptor (BMPR1A) fusion protein increases bone mass and bone formation in mice subjected to hindlimb unloading.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6124165/"
        ),
        Publication(
            id = "PMC8509868",
            "RNAseq and RNA molecular barcoding reveal differential gene expression in cortical bone following hindlimb unloading in female mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8509868/"
        ),
        Publication(
            id = "PMC11063234",
            "Proteomic and phosphoproteomic characterization of cardiovascular tissues after long term exposure to simulated space radiation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11063234/"
        ),
        Publication(
            id = "PMC5672023",
            "Adaptive Changes in the Vestibular System of Land Snail to a 30-Day Spaceflight and Readaptation on Return to Earth",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5672023/"
        ),
        Publication(
            id = "PMC5899691",
            "Morphology of the Utricular Otolith Organ in the Toadfish, Opsanus tau",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5899691/"
        ),
        Publication(
            id = "PMC6204554",
            "Influence of Magnitude and Duration of Altered Gravity and Readaptation to 1g on the Structure and Function of the Utricle in Toadfish, Opsanus tau.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6204554/"
        ),
        Publication(
            id = "PMC4064004",
            "Organization of the ER-Golgi interface for membrane traffic control.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4064004/"
        ),
        Publication(
            id = "PMC3818365",
            "IRE1: ER stress sensor and cell fate executor.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3818365/"
        ),
        Publication(
            id = "PMC3981873",
            "Inter-regulation of the unfolded protein response and auxin signaling.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3981873/"
        ),
        Publication(
            id = "PMC4150462",
            "Endoplasmic reticulum-shape and function in stress translation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4150462/"
        ),
        Publication(
            id = "PMC4378170",
            "Galactose-depleted xycoglucan is dysfunctional and leads to dwarfism in Arabidopsis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4378170/"
        ),
        Publication(
            id = "PMC4618186",
            "Unfolded protein response in plants: one master, many questions.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4618186/"
        ),
        Publication(
            id = "PMC4453782",
            "Vesicles versus Tubes: Is Endoplasmic Reticulum-Golgi Transport in Plants Fundamentally Different from Other Eukaryotes?",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4453782/"
        ),
        Publication(
            id = "PMC4902601",
            "Pectin methylesterification impacts the relationship between photosynthesis and plant growth.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4902601/"
        ),
        Publication(
            id = "PMC4776492",
            "Reduced Chloroplast Coverage genes from Arabidopsis thaliana help to establish the size of the chloroplast compartment",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4776492/"
        ),
        Publication(
            id = "PMC5415411",
            "Maintaining the factory: The roles of the unfolded protein response in cellular homeostasis in plants.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5415411/"
        ),
        Publication(
            id = "PMC6289879",
            "NADPH oxidase activity is required for ER stress survival in plants.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6289879/"
        ),
        Publication(
            id = "PMC7987364",
            "Relevance of the Unfolded Protein Response to Spaceflight-Induced Transcriptional Reprogramming in Arabidopsis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7987364/"
        ),
        Publication(
            id = "PMC8099722",
            "Reanalysis of the Mars500 experiment reveals common gut microbiome alterations in astronauts induced by long-duration confinement",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8099722/"
        ),
        Publication(
            id = "PMC5116466",
            "High atomic weight, high-energy radiation (HZE) induces transcriptional responses shared with conventional stresses in addition to a core \"DSB\" response specific to clastogenic treatments",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5116466/"
        ),
        Publication(
            id = "PMC4033213",
            "Genomic stability in response to high versus low linear energy transfer radiation in Arabidopsis thaliana",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4033213/"
        ),
        Publication(
            id = "PMC6081456",
            "Acceleration profiles and processing methods for parabolic flight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6081456/"
        ),
        Publication(
            id = "PMC5955502",
            "Cytoskeleton structure and total methylation of mouse cardiac and lung tissue during space flight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5955502/"
        ),
        Publication(
            id = "PMC10285634",
            "Toward countering muscle and bone loss with spaceflight: GSK3 as a potential target",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10285634/"
        ),
        Publication(
            id = "PMC11271499",
            "Spaceflight increases sarcoplasmic reticulum Ca2+ leak and this cannot be counteracted with BuOE treatment",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11271499/"
        ),
        Publication(
            id = "PMC6062551",
            "Cardiovascular progenitor cells cultured aboard the International Space Station exhibit altered developmental and functional properties",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6062551/"
        ),
        Publication(
            id = "PMC9832585",
            "Inter-agency perspective: Translating advances in biomarker discovery and medical countermeasures development between terrestrial and space radiation environments",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9832585/"
        ),
        Publication(
            id = "PMC7829349",
            "Genomic and functional characterization of Enterococcus faecalis isolates recovered from the International Space Station and their potential for pathogenicity",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7829349/"
        ),
        Publication(
            id = "PMC3570223",
            "Evaluation of in vitro macrophage differentiation during space flight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3570223/"
        ),
        Publication(
            id = "PMC3457586",
            "Identification of critical host mitochondrion-associated genes during Ehrlichia chaffeensis infections",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3457586/"
        ),
        Publication(
            id = "PMC3558598",
            "Ehrlichia chaffeensis replication sites in adult Drosophila melanogaster.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3558598/"
        ),
        Publication(
            id = "PMC11046949",
            "Development and characterization of two porcine monocyte-derived macrophage cell lines.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11046949/"
        ),
        Publication(
            id = "PMC3890248",
            "Understanding macrophage differentiation during space flight: The importance of ground-based experiments before space flight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3890248/"
        ),
        Publication(
            id = "PMC3868799",
            "Bone marrow leptin signaling mediates obesity-associated adipose tissue inflammation in male mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3868799/"
        ),
        Publication(
            id = "PMC4960141",
            "Establishment and characterization of DB-1: a leptin receptor-deficient murine macrophage cell line",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4960141/"
        ),
        Publication(
            id = "PMC5736159",
            "Validation of methods to assess the immunoglobulin gene repertoire in tissues obtained from mice on the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5736159/"
        ),
        Publication(
            id = "PMC5761896",
            "Characterization of the naive murine antibody repertoire using unamplified high-throughput sequencing",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5761896/"
        ),
        Publication(
            id = "PMC5826609",
            "Effects of spaceflight on the immunoglobulin repertoire of unimmunized C57BL/6 mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5826609/"
        ),
        Publication(
            id = "PMC6366624",
            "A comparison of unamplified and massively multiplexed PCR amplification for murine antibody repertoire sequencing.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6366624/"
        ),
        Publication(
            id = "PMC11929063",
            "Effects of skeletal unloading on the antibody repertoire of tetanus toxoid and/or CpG treated C57BL/6J mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11929063/"
        ),
        Publication(
            id = "PMC11929063",
            "Effects of skeletal unloading on the bone marrow antibody repertoire of tetanus toxoid and/or CpG treated C57BL/6J mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11929063/"
        ),
        Publication(
            id = "PMC10996920",
            "An Analysis of the Effects of Spaceflight and Vaccination on Antibody Repertoire Diversity",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10996920/"
        ),
        Publication(
            id = "PMC7954810",
            "Effects of spaceflight aboard the International Space Station on mouse estrous cycle and ovarian gene expression",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7954810/"
        ),
        Publication(
            id = "PMC4228280",
            "Effect of spaceflight on Pseudomonas aeruginosa final cell density is modulated by nutrient and oxygen availability.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4228280/"
        ),
        Publication(
            id = "PMC3639165",
            "Spaceflight promotes biofilm formation by Pseudomonas aeruginosa.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3639165/"
        ),
        Publication(
            id = "PMC8044432",
            "GeneLab: Omics database for spaceflight experiments",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8044432/"
        ),
        Publication(
            id = "PMC7778922",
            "NASA GeneLab: Interfaces for the exploration of space omics data",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7778922/"
        ),
        Publication(
            id = "PMC7870178",
            "Comprehensive multi-omics analysis reveals mitochondrial stress as a central biological hub for spaceflight impact",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7870178/"
        ),
        Publication(
            id = "PMC7733874",
            "A New Era for Space Life Science: International Standards for Space Omics Processing",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7733874/"
        ),
        Publication(
            id = "PMC7828077",
            "Knowledge Network Embedding of Transcriptomic Data from Spaceflown Mice Uncovers Signs and Symptoms Associated with Terrestrial Diseases",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7828077/"
        ),
        Publication(
            id = "PMC8044432",
            "NASA GeneLab RNA-Seq Consensus Pipeline: Standardized Processing of Short-Read RNA-Seq Data",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8044432/"
        ),
        Publication(
            id = "PMC11166911",
            "Spatially resolved multiomics on the neuronal effects induced by spaceflight in mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166911/"
        ),
        Publication(
            id = "PMC11167097",
            "Biological horizons: pioneering open science in the cosmos",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11167097/"
        ),
        Publication(
            id = "PMC11094041",
            "Inspiration4 data access through the NASA Open Science Data Repository",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11094041/"
        ),
        Publication(
            id = "PMC11053165",
            "NASA GeneLab derived microarray studies of Mus musculus and Homo sapiens organisms in altered gravitational conditions.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11053165/"
        ),
        Publication(
            id = "PMC11403809",
            "Celebrating 30 years of access to NASA space life sciences data",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11403809/"
        ),
        Publication(
            id = "PMC8513672",
            "Dichotomous effects on lymphatic transport with loss of caveolae in mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8513672/"
        ),
        Publication(
            id = "PMC11126634",
            "Fungal diversity differences in the indoor dust microbiome from built environments on Earth and in space.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11126634/"
        ),
        Publication(
            id = "PMC11386075",
            "Predicting how varying moisture conditions impact the microbiome of dust collected from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11386075/"
        ),
        Publication(
            id = "PMC3502426",
            "Aging and estrogen status: A possible endothelium-dependent vascular coupling mechanism in bone remodeling.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3502426/"
        ),
        Publication(
            id = "PMC3856860",
            "Chronic skeletal unloading of the rat femur: mechanisms and functional consequences of vascular remodeling.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3856860/"
        ),
        Publication(
            id = "PMC3615599",
            "Differential effects of aging and exercise on intra-abdominal adipose arteriolar function and blood flow regulation.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3615599/"
        ),
        Publication(
            id = "PMC4050424",
            "Effects of spaceflight and ground recovery on mesenteric artery and vein constrictor properties in mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4050424/"
        ),
        Publication(
            id = "PMC3659353",
            "Spaceflight-induced alterations in cerebral artery vasoconstrictor, mechanical, and structural properties: Implications for elevated cerebral perfusion and intracranial pressure",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3659353/"
        ),
        Publication(
            id = "PMC4169763",
            "Exercise training augments regional bone and marrow blood flow during exercise.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4169763/"
        ),
        Publication(
            id = "PMC4398884",
            "Effects of Skeletal Unloading on the Vasomotor Properties of the Rat Femur Principal Nutrient Artery",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4398884/"
        ),
        Publication(
            id = "PMC4379453",
            "Type 2 diabetes alters bone and marrow blood flow and vascular control mechanisms in the ZDF rat.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4379453/"
        ),
        Publication(
            id = "PMC4385880",
            "Spaceflight on the Bion-M1 biosatellite alters cerebral artery vasomotor and mechanical properties in mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4385880/"
        ),
        Publication(
            id = "PMC4964660",
            "Apollo Lunar Astronauts Show Higher Cardiovascular Disease Mortality: Possible Deep Space Radiation Effects on the Vascular Endothelium",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4964660/"
        ),
        Publication(
            id = "PMC5866446",
            "Effects of age and exercise training on coronary microvascular smooth muscle phenotype and function",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5866446/"
        ),
        Publication(
            id = "PMC6165321",
            "Impact of Spaceflight and Artificial Gravity on the Mouse Retina: Biochemical and Proteomic Analysis.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6165321/"
        ),
        Publication(
            id = "PMC7339929",
            "Simulated microgravity induces regionally distinct neurovascular and structural remodeling of skeletal muscle and cutaneous arteries in the rat",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7339929/"
        ),
        Publication(
            id = "PMC8220224",
            "Spaceflight decelerates the epigenetic clock orchestrated with a global alteration in DNA methylome and transcriptome in the mouse retina",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8220224/"
        ),
        Publication(
            id = "PMC2910419",
            "Development of otolith receptors in Japanese quail.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2910419/"
        ),
        Publication(
            id = "PMC3166430",
            "Spatial and temporal characteristics of vestibular convergence",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3166430/"
        ),
        Publication(
            id = "PMC6615562",
            "Bone remodeling is regulated by inner ear vestibular signals",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6615562/"
        ),
        Publication(
            id = "PMC7324008",
            "Simulated Microgravity Enhances Oligodendrocyte Mitochondrial Function and Lipid Metabolism",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7324008/"
        ),
        Publication(
            id = "PMC8412175",
            "Human Neural Stem Cells Flown into Space Proliferate and Generate Young Neurons",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8412175/"
        ),
        Publication(
            id = "PMC10607959",
            "Delayed Maturation of Oligodendrocyte Progenitors by Microgravity: Implications for Multiple Sclerosis and Space Flight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10607959/"
        ),
        Publication(
            id = "PMC9699585",
            "Space Microgravity Alters Neural Stem Cell Division: Implications for Brain Cancer Research on Earth and in Space",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9699585/"
        ),
        Publication(
            id = "PMC9953055",
            "Oligodendrocyte Progenitors Display Enhanced Proliferation and Autophagy after Space Flight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9953055/"
        ),
        Publication(
            id = "PMC10528075",
            "Metabolomics profile of the secretome of space-flown oligodendrocytes.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10528075/"
        ),
        Publication(
            id = "PMC10813126",
            "Metabolomic profiling of the secretome from human neural stem cells flown into space.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10813126/"
        ),
        Publication(
            id = "PMC10390562",
            "Strategies, research priorities, and challenges for the exploration of space beyond low-Earth orbit",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10390562/"
        ),
        Publication(
            id = "PMC4290804",
            "Spaceflight Induces Specific Alterations in the Proteomes of Arabidopsis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4290804/"
        ),
        Publication(
            id = "PMC5515520",
            "The effect of spaceflight on the gravity-sensing auxin gradient of roots: GFP reporter gene microscopy on orbit.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5515520/"
        ),
        Publication(
            id = "PMC5286820",
            "Skewing in Arabidopsis roots involves disparate environmental signaling pathways.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5286820/"
        ),
        Publication(
            id = "PMC5470433",
            "Data for characterization of SALK_084889, a T-DNA insertion line of Arabidopsis thaliana",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5470433/"
        ),
        Publication(
            id = "PMC5491145",
            "Genetic dissection of the Arabidopsis spaceflight transcriptome: Are some responses dispensable for the physiological adaptation of plants to spaceflight?",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5491145/"
        ),
        Publication(
            id = "PMC5996828",
            "Phenotypic characterization of an Arabidopsis T- DNA insertion line SALK_063500",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5996828/"
        ),
        Publication(
            id = "PMC6201722",
            "Utilization of single‚Äêimage normalized difference vegetation index (SI‚ÄêNDVI) for early plant stress detection",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6201722/"
        ),
        Publication(
            id = "PMC6240453",
            "Comparing RNA-Seq and microarray gene expression data in two zones of the Arabidopsis root apex relevant to spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6240453/"
        ),
        Publication(
            id = "PMC6447593",
            "Spaceflight-induced alternative splicing during seedling development in Arabidopsis thaliana.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6447593/"
        ),
        Publication(
            id = "PMC7264257",
            "The Plant Health Monitoring System of the EDEN ISS Space Greenhouse in Antarctica during the 2018 experiment phase",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7264257/"
        ),
        Publication(
            id = "PMC7064724",
            "Root skewing-associated genes impact the spaceflight response of Arabidopsis thaliana.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7064724/"
        ),
        Publication(
            id = "PMC6379395",
            "Articular cartilage and sternal fibrocartilage respond differently to extended microgravity.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6379395/"
        ),
        Publication(
            id = "PMC4187166",
            "Host-microbe interactions in microgravity: assessment and implications.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4187166/"
        ),
        Publication(
            id = "PMC5219934",
            "Environmental cues and symbiont microbe-associated molecular patterns function in concert to drive the daily remodelling of the crypt-cell brush border of the Euprymna scolopes light organ",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5219934/"
        ),
        Publication(
            id = "PMC6386654",
            "Symbiotic organs shaped by distinct modes of genome evolution in cephalopods.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6386654/"
        ),
        Publication(
            id = "PMC7940393",
            "Modeled microgravity alters lipopolysaccharide and outer membrane vesicle production of the beneficial symbiont Vibrio fischeri",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7940393/"
        ),
        Publication(
            id = "PMC9023564",
            "Emergence of novel cephalopod gene regulation and expression through large-scale genome reorganization",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9023564/"
        ),
        Publication(
            id = "PMC9389742",
            "Modeled microgravity alters apoptotic gene expression and caspase activity in the squid-vibrio symbiosis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9389742/"
        ),
        Publication(
            id = "PMC2824534",
            "In vitro generation of mechanically functional cartilage grafts based on adult human stem cells and 3D-woven poly(epsilon-caprolactone) scaffolds",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2824534/"
        ),
        Publication(
            id = "PMC2991213",
            "Chondrogenesis and mineralization during in vitro culture of human mesenchymal stem cells on three-dimensional woven scaffolds",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2991213/"
        ),
        Publication(
            id = "PMC8269219",
            "Microbiome metadata standards: Report of the National Microbiome Data Collaborative's workshop and follow-on activities.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8269219/"
        ),
        Publication(
            id = "PMC11362537",
            "Spaceflight alters host-gut microbiota interactions",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11362537/"
        ),
        Publication(
            id = "PMC9111996",
            "Asparagine biosynthesis as a mechanism of increased host lethality induced by Serratia marcescens in simulated microgravity environments",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9111996/"
        ),
        Publication(
            id = "PMC10308117",
            "Comparative genomic analysis of Cohnella hashimotonis sp. nov. isolated from the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10308117/"
        ),
        Publication(
            id = "PMC10233975",
            "Characterization of metagenome-assembled genomes from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10233975/"
        ),
        Publication(
            id = "PMC10848226",
            "Biocontrol in built environments to reduce pathogen exposure and infection risk.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10848226/"
        ),
        Publication(
            id = "PMC3329368",
            "Extracellular nucleotides elicit cytosolic free calcium oscillations in Arabidopsis.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3329368/"
        ),
        Publication(
            id = "PMC12008199",
            "Calcium, mechanical signaling, and tip growth",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC12008199/"
        ),
        Publication(
            id = "PMC12008199",
            "Gravitropism and mechanical signaling in plants.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC12008199/"
        ),
        Publication(
            id = "PMC4035928",
            "Salt stress-induced Ca2+ waves are associated with rapid, long-distance root-to-shoot signaling in plants.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4035928/"
        ),
        Publication(
            id = "PMC12034939",
            "Advances in Space Microbiology",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC12034939/"
        ),
        Publication(
            id = "PMC12008199",
            "Gravitropic signaling in plants",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC12008199/"
        ),
        Publication(
            id = "PMC5181587",
            "Wortmannin-induced vacuole fusion enhances amyloplast dynamics in Arabidopsis zigzag1 hypocotyls.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5181587/"
        ),
        Publication(
            id = "PMC4936552",
            "A ROS-assisted calcium wave dependent on AtRBOHD and TPC1 propagates the systemic response to salt stress in Arabidopsis roots",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4936552/"
        ),
        Publication(
            id = "PMC7610290",
            "ROS, calcium and electric signals: Key mediators of rapid systemic signaling in plants",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7610290/"
        ),
        Publication(
            id = "PMC5614317",
            "Real-time In Vivo Recording of Arabidopsis Calcium Signals During Insect Feeding Using a Fluorescent Biosensor",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5614317/"
        ),
        Publication(
            id = "PMC5677518",
            "Orchestrating rapid long-distance signaling in plants with Ca2+ , ROS, and electrical signals",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5677518/"
        ),
        Publication(
            id = "PMC11850895",
            "Glutamate triggers long-distance, calcium-based plant defense signaling.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11850895/"
        ),
        Publication(
            id = "PMC7076552",
            "Test of Arabidopsis Space Transcriptome: A discovery environment to explore multiple plant biology spaceflight experiments.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7076552/"
        ),
        Publication(
            id = "PMC7414185",
            "Tonoplast-localized Ca2+ pumps regulate Ca2+ signals during pattern-triggered immunity in Arabidopsis thaliana.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7414185/"
        ),
        Publication(
            id = "PMC8133610",
            "The fast and the furious: Rapid long-range signaling in plants.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8133610/"
        ),
        Publication(
            id = "PMC8113475",
            "Rad-Bio-App: A discovery environment for biologists to explore spaceflight-related radiation exposures",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8113475/"
        ),
        Publication(
            id = "PMC9706465",
            "The vacuolar H+/Ca transporter CAX1 participates in submergence and anoxia stress responses.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9706465/"
        ),
        Publication(
            id = "PMC10027818",
            "Meta-analysis of the space flight and microgravity response of the Arabidopsis plant transcriptome",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10027818/"
        ),
        Publication(
            id = "PMC3337602",
            "Low-dose, ionizing radiation and age-related changes in skeletal microarchitecture",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3337602/"
        ),
        Publication(
            id = "PMC4490751",
            "Ionizing Radiation Stimulates Expression of Pro-Osteoclastogenic Genes in Marrow and Skeletal Tissue",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4490751/"
        ),
        Publication(
            id = "PMC5132293",
            "Preservation of Multiple Mammalian Tissues to Maximize Science Return from Ground Based and Spaceflight Experiments",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5132293/"
        ),
        Publication(
            id = "PMC11747068",
            "Hindlimb Unloading: Rodent Analog for Microgravity",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11747068/"
        ),
        Publication(
            id = "PMC5666834",
            "Redox Signaling and Its Impact on Skeletal and Vascular Responses to Spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5666834/"
        ),
        Publication(
            id = "PMC6753329",
            "Influence of social isolation during prolonged simulated weightlessness by hindlimb unloading",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6753329/"
        ),
        Publication(
            id = "PMC7012842",
            "Validation of a new Rodent experimental System to investigate consequences of Long Duration Space Habitation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7012842/"
        ),
        Publication(
            id = "PMC4405755",
            "Skeletal tissue regulation by catalase over-expression in mitochondria",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4405755/"
        ),
        Publication(
            id = "PMC8260663",
            "Overexpression of catalase in mitochondria mitigates changes in hippocampal cytokine expression following simulated microgravity and isolation.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8260663/"
        ),
        Publication(
            id = "PMC4647464",
            "An extensive allelic series of Drosophila kae1 mutants reveals diverse and tissue-specific requirements for t6A biogenesis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4647464/"
        ),
        Publication(
            id = "PMC5659752",
            "Novel Organelles with Elements of Bacterial and Eukaryotic Secretion Systems Weaponize Parasites of Drosophila",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5659752/"
        ),
        Publication(
            id = "PMC6372189",
            "A combined computational strategy of sequence and structural analysis predicts the existence of a functional eicosanoid pathway in Drosophila melanogaster.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6372189/"
        ),
        Publication(
            id = "PMC6945029",
            "Immune suppressive extracellular vesicle proteins of Leptopilina heterotoma are encoded in the wasp genome.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6945029/"
        ),
        Publication(
            id = "PMC7000411",
            "Spaceflight and simulated microgravity conditions increase virulence of Serratia marcescens in the Drosophila melanogaster infection model.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7000411/"
        ),
        Publication(
            id = "PMC8191917",
            "A parasitoid wasp of Drosophila employs preemptive and reactive strategies to deplete its host's blood cells",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8191917/"
        ),
        Publication(
            id = "PMC9865768",
            "In Silico Analysis of a Drosophila Parasitoid Venom Peptide Reveals Prevalence of the Cation‚ÄìPolar‚ÄìCation Clip Motif in Knottin Proteins",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9865768/"
        ),
        Publication(
            id = "PMC10797188",
            "Drosophila parasitoids go to space: Unexpected effects of spaceflight on hosts and their parasitoids.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10797188/"
        ),
        Publication(
            id = "PMC10797188",
            "Drosophila parasitoids go to space: Unexpected effects of spaceflight on hosts and their parasitoids",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10797188/"
        ),
        Publication(
            id = "PMC7555395",
            "Simultaneous exposure of cultured human lymphoblastic cells to simulated microgravity and radiation increases chromosome aberrations",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7555395/"
        ),
        Publication(
            id = "PMC4309212",
            "Genes required for survival in microgravity revealed by genome-wide yeast deletion collections cultured during spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4309212/"
        ),
        Publication(
            id = "PMC6560652",
            "Physical Forces Modulate Oxidative Status and Stress Defense Meditated Metabolic Adaptation of Yeast Colonies: Spaceflight and Microgravity Simulations",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6560652/"
        ),
        Publication(
            id = "PMC6321533",
            "Effects of space flight on mouse liver versus kidney: Gene pathway analyses.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6321533/"
        ),
        Publication(
            id = "PMC12040010",
            "Yeast in Space",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC12040010/"
        ),
        Publication(
            id = "PMC11833055",
            "Endocrine Effects of Space Flight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11833055/"
        ),
        Publication(
            id = "PMC9146534",
            "Role of shear stress on renal proximal tubular cells for nephrotoxicity assays",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9146534/"
        ),
        Publication(
            id = "PMC11492218",
            "Bone hemodynamic responses to changes in external pressure.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11492218/"
        ),
        Publication(
            id = "PMC6339989",
            "Back pain in space and post-flight spine injury: Mechanisms and countermeasure development",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6339989/"
        ),
        Publication(
            id = "PMC4110898",
            "Fifteen days of microgravity causes growth in calvaria of mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4110898/"
        ),
        Publication(
            id = "PMC3947616",
            "Altered disc compression in children with idiopathic low back pain: an upright magnetic resonance imaging backpack study",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3947616/"
        ),
        Publication(
            id = "PMC5477841",
            "Spaceflight-induced bone loss alters failure mode and reduces bending strength in murine spinal segments.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5477841/"
        ),
        Publication(
            id = "PMC9139491",
            "Spaceflight-associated vascular remodeling and gene expression in mouse calvaria.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9139491/"
        ),
        Publication(
            id = "PMC5515531",
            "Exposure of Mycobacterium marinum to low-shear modeled microgravity: Effect on growth, the transcriptome and survival under stress.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5515531/"
        ),
        Publication(
            id = "PMC3258067",
            "Effects of mechanostimulation on gravitropism and signal persistence in flax roots.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3258067/"
        ),
        Publication(
            id = "PMC10025027",
            "Oxygen dependency of germinating Brassica seeds.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10025027/"
        ),
        Publication(
            id = "PMC7733933",
            "Desiccation mitigates heat stress in the resurrection fern, Pleopeltis polypodioides",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7733933/"
        ),
        Publication(
            id = "PMC9105288",
            "Transcription profile of auxin related genes during positively gravitropic hypocotyl curvature of Brassica rapa.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9105288/"
        ),
        Publication(
            id = "PMC9617909",
            "High-gradient magnetic fields and starch metabolism: Results from a space experiment.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9617909/"
        ),
        Publication(
            id = "PMC9695138",
            "Lipid rafts and plant gravisensitivity.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9695138/"
        ),
        Publication(
            id = "PMC3503204",
            "Expression and characterization of the bacterial mechanosensitive channel MscS in Xenopus laevis oocytes",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3503204/"
        ),
        Publication(
            id = "PMC5896955",
            "United in Diversity: Mechanosensitive Ion Channels in Plants",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5896955/"
        ),
        Publication(
            id = "PMC4469364",
            "Expressing and Characterizing Mechanosensitive Channels in Xenopus Oocytes",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4469364/"
        ),
        Publication(
            id = "PMC4411250",
            "The ongoing search for the molecular basis of plant osmosensing",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4411250/"
        ),
        Publication(
            id = "PMC5047659",
            "Plastid osmotic stress influences cell differentiation at the plant shoot apex.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5047659/"
        ),
        Publication(
            id = "PMC5454470",
            "Spaceflight-induced synaptic modifications within hair cells of the mammalian utricle.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5454470/"
        ),
        Publication(
            id = "PMC5515506",
            "Effects of angular frequency during clinorotation on mesenchymal stem cell morphology and migration",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5515506/"
        ),
        Publication(
            id = "PMC3044105",
            "The role of FGF-2 and BMP-2 in regulation of gene induction, cell proliferation and mineralization.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3044105/"
        ),
        Publication(
            id = "PMC3002170",
            "Nutritional supplements, COX-2 and IGF-1 expression in men on active surveillance for prostate cancer.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3002170/"
        ),
        Publication(
            id = "PMC6188462",
            "To Infinity and Beyond! Human spaceflight and life science.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6188462/"
        ),
        Publication(
            id = "PMC11470607",
            "Hyperoxia inhibits T cell activation in mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11470607/"
        ),
        Publication(
            id = "PMC3603133",
            "Effects of gravitational mechanical unloading in endothelial cells: association between caveolins, inflammation and adhesion molecules",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3603133/"
        ),
        Publication(
            id = "PMC6462350",
            "n-3 Polyunsaturated fatty acids supplementation in peripheral artery disease: the OMEGA-PAD trial",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6462350/"
        ),
        Publication(
            id = "PMC4012541",
            "Molecular mechanisms underlying the enhanced functions of three-dimensional hepatocyte aggregates",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4012541/"
        ),
        Publication(
            id = "PMC4653058",
            "Spaceflight alters expression of microRNA during T-cell activation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4653058/"
        ),
        Publication(
            id = "PMC6137544",
            "Spaceflight impairs antigen-specific tolerance induction in vivo and increases inflammatory cytokines.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6137544/"
        ),
        Publication(
            id = "PMC2913424",
            "From cellular mechanotransduction to biologically inspired engineering: 2009 Pritzker Award Lecture, BMES Annual Meeting October 10, 2009.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2913424/"
        ),
        Publication(
            id = "PMC7190111",
            "Crewmember microbiome may influence microbial composition of ISS habitable surfaces",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7190111/"
        ),
        Publication(
            id = "PMC7382458",
            "Sierra Nevada sweep: Metagenomic measurements of bioaerosols vertically distributed across the troposphere.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7382458/"
        ),
        Publication(
            id = "PMC8444978",
            "Draft Genome Sequences of Fungi Isolated from the International Space Station during the Microbial Tracking-2 Experiment",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8444978/"
        ),
        Publication(
            id = "PMC9241228",
            "Microbial tracking-2, a metagenomics analysis of bacteria and fungi onboard the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9241228/"
        ),
        Publication(
            id = "PMC8953707",
            "Detection of Target Genes for Drug Repurposing to Treat Skeletal Muscle Atrophy in Mice Flown in Spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8953707/"
        ),
        Publication(
            id = "PMC11166646",
            "Release of CD36-associated cell-free mitochondrial DNA and RNA as a hallmark of space environment response",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166646/"
        ),
        Publication(
            id = "PMC3747666",
            "Increasing the number of unloading/reambulation cycles does not adversely impac body composition and lumbar bone mineral density but reduces tissue sensitivity",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3747666/"
        ),
        Publication(
            id = "PMC4337661",
            "Bone shaft bending strength index is unaffected by exercise and unloading in mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4337661/"
        ),
        Publication(
            id = "PMC4631774",
            "Focal enhancement of the skeleton to exercise correlates to mesenchymal stem cell responsivity rather than peak external forces.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4631774/"
        ),
        Publication(
            id = "PMC5052530",
            "Cytoskeletal configuration modulates mechanically induced changes in mesenchymal stem cell osteogenesis, morphology, and stiffness.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5052530/"
        ),
        Publication(
            id = "PMC5114340",
            "Genetic and tissue level muscle-bone interactions during unloading and reambulation.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5114340/"
        ),
        Publication(
            id = "PMC5488280",
            "Osteocyte apoptosis caused by hindlimb unloading is required to trigger osteocyte RANKL production and subsequent resorption of cortical and trabecular bone in mice femurs.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5488280/"
        ),
        Publication(
            id = "PMC9293686",
            "Differential Single Cell Responses of Embryonic Stem Cells Versus Embryoid Bodies to Gravity Mechanostimulation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9293686/"
        ),
        Publication(
            id = "PMC6091969",
            "Macrophages inhibit Aspergillus fumigatus germination and neutrophil-mediated fungal killing.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6091969/"
        ),
        Publication(
            id = "PMC7029147",
            "Contributions of spore secondary metabolites to UV-C protection and virulence vary in different Aspergillus fumigatus strains",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7029147/"
        ),
        Publication(
            id = "PMC3092937",
            "Regulation of hemocytes in Drosophila requires dappled cytochrome b5.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3092937/"
        ),
        Publication(
            id = "PMC5748516",
            "A novel phototropic response to red light is revealed in microgravity.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5748516/"
        ),
        Publication(
            id = "PMC9287483",
            "Plant cell proliferation and growth are altered by microgravity conditions in spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9287483/"
        ),
        Publication(
            id = "PMC5748516",
            "Phototropism of Arabidopsis thaliana in microgravity and fractional gravity on the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5748516/"
        ),
        Publication(
            id = "PMC4211383",
            "Light and gravity signals synergize in modulating plant development",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4211383/"
        ),
        Publication(
            id = "PMC5748516",
            "A novel blue-light phototropic response is revealed in roots of Arabidopsis thaliana in microgravity.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5748516/"
        ),
        Publication(
            id = "PMC5821596",
            "Comparative transcriptomics indicate changes in cell wall organization and stress response in seedlings during spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5821596/"
        ),
        Publication(
            id = "PMC6889863",
            "RNAseq analysis of the response of Arabidopsis thaliana to fractional gravity under blue-light stimulation during spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6889863/"
        ),
        Publication(
            id = "PMC6908503",
            "Comparison of Microgravity Analogs to Spaceflight in Studies of Plant Growth and Development",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6908503/"
        ),
        Publication(
            id = "PMC7607443",
            "The importance of Earth reference controls in spaceflight-omics research: Characterization of nucleolin mutants from the Seedling Growth experiments",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7607443/"
        ),
        Publication(
            id = "PMC10764921",
            "Conducting plant experiments in space and on the Moon",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10764921/"
        ),
        Publication(
            id = "PMC9605285",
            "Red light enhances plant adaptation to spaceflight and Mars g-levels.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9605285/"
        ),
        Publication(
            id = "PMC3962621",
            "EUK-134 ameliorates nNOS¬µ translocation and skeletal muscle fiber atrophy during short-term mechanical unloading.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3962621/"
        ),
        Publication(
            id = "PMC4462657",
            "MnSOD Overexpression Reduces Fibrosis and Pro-Apoptotic Signaling in the Aging Mouse Heart",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4462657/"
        ),
        Publication(
            id = "PMC5026643",
            "Lifelong wheel running exercise and mild caloric restriction attenuate nuclear EndoG in the aging plantaris muscle.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5026643/"
        ),
        Publication(
            id = "PMC5026642",
            "Age-related alterations in the sarcolemmal environment are attenuated by lifelong caloric restriction and voluntary exercise.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5026642/"
        ),
        Publication(
            id = "PMC10342025",
            "The impact of SRT2104 on skeletal muscle mitochondrial function, redox biology, and loss of muscle mass in hindlimb unloaded rats.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10342025/"
        ),
        Publication(
            id = "PMC11167039",
            "Bioreactor development for skeletal muscle hypertrophy and atrophy by manipulating uniaxial cyclic strain: Proof of concept.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11167039/"
        ),
        Publication(
            id = "PMC10020673",
            "Genomic and phenotypic characterization of Burkholderia isolates from the potable water system of the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10020673/"
        ),
        Publication(
            id = "PMC9144607",
            "CAMDLES: CFD-DEM Simulation of Microbial Communities in Spaceflight and Artificial Microgravity",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9144607/"
        ),
        Publication(
            id = "PMC7314936",
            "Hardware validation of the Advanced Plant Habitat on ISS: Canopy photosynthesis in reduced gravity.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7314936/"
        ),
        Publication(
            id = "PMC4340379",
            "Trimeric structure of (+)-pinoresinol-forming dirigent protein at 1.95 A resolution with three isolated active sites.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4340379/"
        ),
        Publication(
            id = "PMC5933128",
            "Reduced Arogenate Dehydratase Expression: Ramifications for Photosynthesis and Metabolism",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5933128/"
        ),
        Publication(
            id = "PMC8185232",
            "New insights into lignification via network and multi-omics analyses of arogenate dehydratase knock-out mutants in Arabidopsis thaliana",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8185232/"
        ),
        Publication(
            id = "PMC3936501",
            "Functional consequences of radiation-induced oxidative stress in cultured neural stem cells and the brain exposed to charged particle irradiation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3936501/"
        ),
        Publication(
            id = "PMC11998595",
            "Exploration of space to achieve scientific breakthroughs",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11998595/"
        ),
        Publication(
            id = "PMC7996555",
            "Network Analysis of Gene Transcriptions of Arabidopsis thaliana in Spaceflight Microgravity.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7996555/"
        ),
        Publication(
            id = "PMC8234954",
            "Detection of Genes in Arabidopsis thaliana L. Responding to DNA Damage from Radiation and Other Stressors in Spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8234954/"
        ),
        Publication(
            id = "PMC4152162",
            "The Effect of spaceflight on mouse olfactory bulb volume, neurogenesis, and cell death indicates the protective effect of novel environment.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4152162/"
        ),
        Publication(
            id = "PMC5498037",
            "Effects of low-dose rate Œ≥-irradiation combined with simulated microgravity on markers of oxidative stress, DNA methylation potential, and remodeling in the mouse heart",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5498037/"
        ),
        Publication(
            id = "PMC6547757",
            "Characterization of mouse ocular response to a 35-day spaceflight mission: Evidence of blood-retinal barrier disruption and ocular adaptations.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6547757/"
        ),
        Publication(
            id = "PMC6747492",
            "Mice Exposed to Combined Chronic Low-Dose Irradiation and Modeled Microgravity Develop Long-Term Neurological Sequelae.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6747492/"
        ),
        Publication(
            id = "PMC6746706",
            "Spaceflight influences gene expression, photoreceptor integrity, and oxidative stress-related damage in the murine retina.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6746706/"
        ),
        Publication(
            id = "PMC8400407",
            "Evaluating ocular response in the retina and optic nerve head after single and fractionated high-energy protons",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8400407/"
        ),
        Publication(
            id = "PMC9365836",
            "Characterization of gene expression profiles in the mouse brain after 35 days of spaceflight mission.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9365836/"
        ),
        Publication(
            id = "PMC9547011",
            "A multi-omics longitudinal study of the murine retinal response to chronic low-dose irradiation and simulated microgravity.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9547011/"
        ),
        Publication(
            id = "PMC10138634",
            "Evidence of spaceflight-induced adverse effects on photoreceptors and retinal function in the mouse eye.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10138634/"
        ),
        Publication(
            id = "PMC12031868",
            "Effects of spaceflight on the brain",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC12031868/"
        ),
        Publication(
            id = "PMC9583032",
            "Routine omics collection is a golden opportunity for European human research in space and analog environments.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9583032/"
        ),
        Publication(
            id = "PMC9746133",
            "Spatial omics technologies at multimodal and single cell/subcellular level.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9746133/"
        ),
        Publication(
            id = "PMC10422843",
            "Genomic characterization and radiation tolerance of Naganishia kalamii sp. nov. and Cystobasidium onofrii sp. nov. from Mars 2020 mission assembly facilities.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10422843/"
        ),
        Publication(
            id = "PMC11022651",
            "Genome and clonal hematopoiesis stability contrasts with immune, cfDNA, mitochondrial, and telomere length changes during short duration spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11022651/"
        ),
        Publication(
            id = "PMC11094041",
            "Inspiration4 data access through the NASA Open Science Data Repository",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11094041/"
        ),
        Publication(
            id = "PMC11357997",
            "Molecular and physiologic changes in the SpaceX Inspiration4 civilian crew",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11357997/"
        ),
        Publication(
            id = "PMC11167063",
            "Telomeric RNA (TERRA) increases in response to spaceflight and high-altitude climbing",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11167063/"
        ),
        Publication(
            id = "PMC11166909",
            "Spatial multi-omics of human skin reveals KRAS and inflammatory responses to spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166909/"
        ),
        Publication(
            id = "PMC11222149",
            "Longitudinal multi-omics analysis of host microbiome architecture and immune responses during short-term spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11222149/"
        ),
        Publication(
            id = "PMC11166948",
            "Spatiotemporal expression and control of haemoglobin in space",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166948/"
        ),
        Publication(
            id = "PMC11166952",
            "Single-cell multi-ome and immune profiles of the Inspiration4 crew reveal conserved, cell-type, and sex-specific responses to spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166952/"
        ),
        Publication(
            id = "PMC11166937",
            "Single-cell analysis identifies conserved features of immune dysfunction in simulated microgravity and spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166937/"
        ),
        Publication(
            id = "PMC11357981",
            "The Space Omics and Medical Atlas (SOMA) and international astronaut biobank",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11357981/"
        ),
        Publication(
            id = "PMC11166969",
            "Secretome profiling reveals acute changes in oxidative stress, brain homeostasis, and coagulation following short-duration spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166969/"
        ),
        Publication(
            id = "PMC11166943",
            "Astronaut omics and the impact of space on the human body at scale",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166943/"
        ),
        Publication(
            id = "PMC11166967",
            "Transcriptomics analysis reveals molecular alterations underpinning spaceflight dermatology.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166967/"
        ),
        Publication(
            id = "PMC11167060",
            "Cosmic kidney disease: an integrated pan-omic, physiological and morphological study into spaceflight-induced renal dysfunction",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11167060/"
        ),
        Publication(
            id = "PMC11166981",
            "Spaceflight induces changes in gene expression profiles linked to insulin and estrogen",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166981/"
        ),
        Publication(
            id = "PMC11263583",
            "Protective alleles and precision healthcare in crewed spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11263583/"
        ),
        Publication(
            id = "PMC11484870",
            "To boldly go where no microRNAs have gone before: Spaceflight impact on risk for small-for-gestational-age infants",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11484870/"
        ),
        Publication(
            id = "PMC10780891",
            "Growth chambers on the International Space Station for large plants",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10780891/"
        ),
        Publication(
            id = "PMC7067979",
            "Microbiological and nutritional analysis of lettuce crops grown on the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7067979/"
        ),
        Publication(
            id = "PMC4321547",
            "Natural variation in the expression of ORGANIC CATION TRANSPORTER 1 affects root length responses to cadaverine in Arabidopsis.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4321547/"
        ),
        Publication(
            id = "PMC6710492",
            "Auxin: Shape matters.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6710492/"
        ),
        Publication(
            id = "PMC12008199",
            "Gravity signaling in flowering plant roots",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC12008199/"
        ),
        Publication(
            id = "PMC8518694",
            "Cadaverine regulates biotin synthesis to modulate primary root growth in Arabidopsis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8518694/"
        ),
        Publication(
            id = "PMC9861679",
            "Low-speed clinorotation of Brachypodium distachyon and Arabidopsis thaliana seedlings triggers root tip curvatures that are reminiscent of gravitropism.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9861679/"
        ),
        Publication(
            id = "PMC2897429",
            "New device for high-throughput viability screening of flow biofilms",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2897429/"
        ),
        Publication(
            id = "PMC4187989",
            "Sigma S-dependent antioxidant defense protects stationary-phase Escherichia coli against the bactericidal antibiotic gentamicin",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4187989/"
        ),
        Publication(
            id = "PMC8217198",
            "Plasma membrane disruption (PMD) formation and repair in mechanosensitive tissues",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8217198/"
        ),
        Publication(
            id = "PMC6981245",
            "Microgravity alters the expression of salivary proteins",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6981245/"
        ),
        Publication(
            id = "PMC6981245",
            "Salivary Gland Protein Expression after Bion-M1 and Space Shuttle STS-135 Missions",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6981245/"
        ),
        Publication(
            id = "PMC6131065",
            "Response of the mouse sublingual gland to spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6131065/"
        ),
        Publication(
            id = "PMC11233762",
            "Effects of spaceflight on the mouse submandibular gland",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11233762/"
        ),
        Publication(
            id = "PMC6213004",
            "Reactivation of Latent Epstein-Barr Virus: A Comparison after Exposure to Gamma, Proton, Carbon, and Iron Radiation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6213004/"
        ),
        Publication(
            id = "PMC7171750",
            "The influence of spaceflight on the astronaut salivary microbiome and the search for a microbiome biomarker for viral reactivation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7171750/"
        ),
        Publication(
            id = "PMC10414970",
            "The cyclic nucleotide-gated channel CNGC14 regulates root gravitropism in Arabidopsis thaliana.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10414970/"
        ),
        Publication(
            id = "PMC8450295",
            "Telomere length assessments of muscle stem cells in rodent and human skeletal muscle sections",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8450295/"
        ),
        Publication(
            id = "PMC8183356",
            "Persistent NF-Œ∫B activation in muscle stem cells induces proliferation-independent telomere shortening",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8183356/"
        ),
        Publication(
            id = "PMC8932657",
            "Piezo1 regulates the regenerative capacity of skeletal muscles via orchestration of stem cell morphological states.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8932657/"
        ),
        Publication(
            id = "PMC10504369",
            "Impacts of radiation exposure, hindlimb unloading, and recovery on murine skeletal muscle cell telomere length.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10504369/"
        ),
        Publication(
            id = "PMC3982735",
            "Ethylene-induced flavonol accumulation in guard cells suppresses reactive oxygen species and modulates stomatal aperture",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3982735/"
        ),
        Publication(
            id = "PMC4682325",
            "Transcriptional and Hormonal Regulation of Gravitropism of Woody Stems in Populus.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4682325/"
        ),
        Publication(
            id = "PMC10264680",
            "Endosidin2 targets conserved exocyst complex subunit EXO70 to inhibit exocytosis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10264680/"
        ),
        Publication(
            id = "PMC7358545",
            "A conditional mutation in SCD1 reveals linkage between PIN protein trafficking, auxin transport, gravitropism, and lateral root initiation.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7358545/"
        ),
        Publication(
            id = "PMC9108708",
            "A comprehensive SARS-CoV-2 and COVID-19 review, Part 1: Intracellular overdrive for SARS-CoV-2 infection.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9108708/"
        ),
        Publication(
            id = "PMC7555797",
            "Changes in nuclear shape and gene expression in response to simulated microgravity are LINC complex-dependent.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7555797/"
        ),
        Publication(
            id = "PMC3545801",
            "Growth of Carnobacterium spp. from permafrost under low pressure, temperature, and anoxic atmosphere has implications for Earth microbes on Mars",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3545801/"
        ),
        Publication(
            id = "PMC3869332",
            "Complete Genome Sequence of Carnobacterium gilichinskyi Strain WN1359T (DSM 27470T)",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3869332/"
        ),
        Publication(
            id = "PMC4135744",
            "Exposure of Bacillus subtilis to low pressure (5 kilopascals) induces several global regulons, including those involved in the SigB-mediated general stress response",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4135744/"
        ),
        Publication(
            id = "PMC3911009",
            "Resistance of Bacillus subtilis Spore DNA to Lethal Ionizing Radiation Damage Relies Primarily on Spore Core Components and DNA Repair, with Minor Effects of Oxygen Radical Detoxification",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3911009/"
        ),
        Publication(
            id = "PMC4923109",
            "Cultivation of Staphylococcus epidermidis in the human spaceflight environment leads to alterations in the frequency and spectrum of spontaneous rifampicin-resistance mutations in the rpoB gene",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4923109/"
        ),
        Publication(
            id = "PMC11673879",
            "Experimental Evolution of Bacillus subtilis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11673879/"
        ),
        Publication(
            id = "PMC5648920",
            "Cultivation in space flight produces minimal alterations in the susceptibility of Bacillus subtilis cells to 72 different antibiotics and growth-inhibiting compounds",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5648920/"
        ),
        Publication(
            id = "PMC5817088",
            "Alterations in the Spectrum of Spontaneous Rifampicin-Resistance Mutations in the Bacillus subtilis rpoB Gene after Cultivation in the Human Spaceflight Environment",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5817088/"
        ),
        Publication(
            id = "PMC7825584",
            "Mechanotransduction in Prokaryotes: A Possible Mechanism of Spaceflight Adaptation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7825584/"
        ),
        Publication(
            id = "PMC8904044",
            "Environmental dependence of competitive fitness in rifampin-resistant rpoB mutants of Bacillus subtilis.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8904044/"
        ),
        Publication(
            id = "PMC3012082",
            "Analysis of interactions of Salmonella type three secretion mutants with 3-D intestinal epithelial cells.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3012082/"
        ),
        Publication(
            id = "PMC11088941",
            "Organotypic 3D cell culture models: using the rotating wall vessel to study host-pathogen interactions.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11088941/"
        ),
        Publication(
            id = "PMC3187170",
            "Induction of attachment-independent biofilm formation and repression of Hfq expression by low-fluid-shear culture of Staphylococcus aureus",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3187170/"
        ),
        Publication(
            id = "PMC3133089",
            "Characterization of the Salmonella enterica serovar Typhimurium ydcI gene which encodes a conserved DNA binding protein required for full acid stress resistance.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3133089/"
        ),
        Publication(
            id = "PMC3242767",
            "Evaluation of microorganisms cultured from injured and repressed tissue regeneration sites in endangered giant aquatic Ozark Hellbender salamanders.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3242767/"
        ),
        Publication(
            id = "PMC3067220",
            "Transcriptional and proteomic responses of Pseudomonas aeruginosa PAO1 to spaceflight conditions involve Hfq regulation and reveal a role for oxygen.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3067220/"
        ),
        Publication(
            id = "PMC3251573",
            "New insights into the bacterial fitness-associated mechanisms revealed by the characterization of large plasmids of an avian pathogenic E. coli",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3251573/"
        ),
        Publication(
            id = "PMC3647661",
            "Lack of norovirus replication and histo-blood group antigen expression in 3-dimensional intestinal epithelial cells",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3647661/"
        ),
        Publication(
            id = "PMC4085587",
            "Conservation of the low-shear modeled microgravity response in Enterobacteriaceae and analysis of the trp genes in this response.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4085587/"
        ),
        Publication(
            id = "PMC4096993",
            "Mimicking the host and its microenvironment in vitro for studying mucosal infections by Pseudomonas aeruginosa.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4096993/"
        ),
        Publication(
            id = "PMC7467030",
            "Effects of Sex and Gender on Adaptation to Space: Immune System",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7467030/"
        ),
        Publication(
            id = "PMC4427280",
            "Recellularization of decellularized lung scaffolds is enhanced by dynamic suspension culture.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4427280/"
        ),
        Publication(
            id = "PMC5460263",
            "Three-dimensional organotypic co-culture model of intestinal epithelial cells and macrophages to study Salmonella enterica colonization patterns.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5460263/"
        ),
        Publication(
            id = "PMC6204695",
            "Modeling Host-Pathogen Interactions in the Context of the Microenvironment: 3-D Cell Culture Comes of Age.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6204695/"
        ),
        Publication(
            id = "PMC7943786",
            "Evaluating the effect of spaceflight on the host‚Äìpathogen interaction between human intestinal epithelial cells and Salmonella Typhimurium",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7943786/"
        ),
        Publication(
            id = "PMC11888247",
            "Rapid phenotypic response of LSMMG-'primed' Candida albicans.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11888247/"
        ),
        Publication(
            id = "PMC3851762",
            "Spaceflight enhances cell aggregation and random budding in Candida albicans.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3851762/"
        ),
        Publication(
            id = "PMC8067245",
            "Growth and antifungal resistance of the pathogenic yeast, Candida albicans, in the microgravity environment of the International Space Station: An aggregate of multiple flight experiences.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8067245/"
        ),
        Publication(
            id = "PMC8044432",
            "NASA GeneLab RNA-Seq Consensus Pipeline: Standardized Processing of Short-Read RNA-Seq Data",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8044432/"
        ),
        Publication(
            id = "PMC9701605",
            "Challenges and considerations for single-cell and spatially resolved transcriptomics sample collection during spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9701605/"
        ),
        Publication(
            id = "PMC11166648",
            "Direct RNA sequencing of astronaut blood reveals spaceflight-associated m6A increases and hematopoietic transcriptional responses",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166648/"
        ),
        Publication(
            id = "PMC11166662",
            "Collection of biospecimens from the inspiration4 mission establishes the standards for the space omics and medical atlas (SOMA)",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166662/"
        ),
        Publication(
            id = "PMC3838407",
            "Microfluidics-enabled method to identify modes of Caenorhabditis elegans paralysis in four anthelmintics.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3838407/"
        ),
        Publication(
            id = "PMC3748764",
            "Multiparameter behavioral analyses provide insights to mechanisms of cyanide resistance in Caenorhabditis elegans.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3748764/"
        ),
        Publication(
            id = "PMC2925951",
            "Growth performance and root transcriptome remodeling of Arabidopsis in response to Mars-like levels of magnesium sulfate.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2925951/"
        ),
        Publication(
            id = "PMC3350920",
            "The 14-3-3 proteins of Arabidopsis regulate root growth and chloroplast development as components of the photosensory system.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3350920/"
        ),
        Publication(
            id = "PMC3422896",
            "14-3-3 phosphoprotein interaction networks - does isoform diversity present functional interaction specification?",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3422896/"
        ),
        Publication(
            id = "PMC11869762",
            "Plant growth strategies are remodeled by spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11869762/"
        ),
        Publication(
            id = "PMC10712242",
            "Spaceflight transcriptomes: unique responses to a novel environment.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10712242/"
        ),
        Publication(
            id = "PMC6143729",
            "Fundamental plant biology enabled by the space shuttle.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6143729/"
        ),
        Publication(
            id = "PMC10058394",
            "Organ-specific remodeling of the Arabidopsis transcriptome in response to spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10058394/"
        ),
        Publication(
            id = "PMC4103452",
            "A method for preparing spaceflight RNAlater-fixed Arabidopsis thaliana (Brassicaceae) tissue for scanning electron microscopy.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4103452/"
        ),
        Publication(
            id = "PMC8024390",
            "ARG1 Functions in the Physiological Adaptation of Undifferentiated Plant Cells to Spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8024390/"
        ),
        Publication(
            id = "PMC6348315",
            "A Member of the CONSTANS-Like Protein Family is a Putative Regulator of ROS Homeostasis and Spaceflight Physiological Adaptation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6348315/"
        ),
        Publication(
            id = "PMC6359015",
            "HSFA2 Functions in the Physiological Adaptation of Undifferentiated Plant Cells to Spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6359015/"
        ),
        Publication(
            id = "PMC7667275",
            "Neutrophil to Lymphocyte ratio: A biomarker to monitor the immune status of astronauts.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7667275/"
        ),
        Publication(
            id = "PMC7756144",
            "Beyond low-Earth orbit: Characterizing immune and microRNA differentials following simulated deep spaceflight conditions in mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7756144/"
        ),
        Publication(
            id = "PMC8169688",
            "Immunological and hematological outcomes following protracted low dose/low dose rate ionizing radiation and simulated microgravity",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8169688/"
        ),
        Publication(
            id = "PMC8475764",
            "Epigenomic regulators elongator complex subunit 2 and methyltransferase 1 differentially condition the spaceflight response in Arabidopsis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8475764/"
        ),
        Publication(
            id = "PMC9098553",
            "Plants grown in Apollo lunar regolith present stress-associated transcriptomes that inform prospects for lunar exploration",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9098553/"
        ),
        Publication(
            id = "PMC10503492",
            "Artificial gravity partially protects space-induced neurological deficits in Drosophila melanogaster.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10503492/"
        ),
        Publication(
            id = "PMC9693084",
            "Utilizing the KSC fixation tube to conduct human-tended plant biology experiments on a suborbital spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9693084/"
        ),
        Publication(
            id = "PMC3792163",
            "Changes in Mouse Thymus and Spleen after Return from the STS-135 Mission in Space",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3792163/"
        ),
        Publication(
            id = "PMC4430214",
            "Post-Spaceflight (STS-135) Mouse Splenocytes Demonstrate Altered Activation Properties and Surface Molecule Expression.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4430214/"
        ),
        Publication(
            id = "PMC5045078",
            "Changes in the distribution and function of leukocytes after whole-body iron ion irradiation.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5045078/"
        ),
        Publication(
            id = "PMC5443495",
            "Is spaceflight-induced immune dysfunction linked to systemic changes in metabolism?",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5443495/"
        ),
        Publication(
            id = "PMC5666744",
            "Spaceflight Activates Autophagy Programs and the Proteasome in Mouse Liver",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5666744/"
        ),
        Publication(
            id = "PMC5865701",
            "Vive la radior√©sistance!: Converging research in radiobiology and biogerontology to enhance human radioresistance for deep space exploration and colonization.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5865701/"
        ),
        Publication(
            id = "PMC6337482",
            "Proteomic analysis of mouse brain subjected to spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6337482/"
        ),
        Publication(
            id = "PMC9953463",
            "Transcriptomic effects on the mouse heart following 30 days on the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9953463/"
        ),
        Publication(
            id = "PMC10487739",
            "Spaceflight-induced gene expression profiles in the mouse brain are attenuated by treatment with the antioxidant BuOE",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10487739/"
        ),
        Publication(
            id = "PMC11942576",
            "Basal signaling regulates plant growth and development",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11942576/"
        ),
        Publication(
            id = "PMC4052902",
            "Phosphoinositide-signaling is one component of a robust plant defense response",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4052902/"
        ),
        Publication(
            id = "PMC8539686",
            "Uncovering transcriptional responses to fractional gravity in Arabidopsis roots",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8539686/"
        ),
        Publication(
            id = "PMC10800490",
            "Conserved plant transcriptional responses to microgravity from two consecutive spaceflight experiments.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10800490/"
        ),
        Publication(
            id = "PMC7756143",
            "RNAseq analysis of rodent spaceflight experiments is confounded by sample collection techniques",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7756143/"
        ),
        Publication(
            id = "PMC3066201",
            "Functional changes in the snail statocyst system elicited by microgravity",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3066201/"
        ),
        Publication(
            id = "PMC11324864",
            "Simulated microgravity impairs human NK [natural killer] cell cytotoxic activity against space radiation-relevant leukemic cells",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11324864/"
        ),
        Publication(
            id = "PMC3665236",
            "Multi-analyte biochip (MAB) based on all-solid-state ion-selective electrodes (ASSISE) for physiological research",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3665236/"
        ),
        Publication(
            id = "PMC10470837",
            "Lab-on-a-chip approaches for space-biology research.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10470837/"
        ),
        Publication(
            id = "PMC10386755",
            "Plant chemical genomics: gravity sensing and response.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10386755/"
        ),
        Publication(
            id = "PMC8896891",
            "The interaction of vortical flows with red cells in venous valve mimics.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8896891/"
        ),
        Publication(
            id = "PMC8430797",
            "Mammalian and Invertebrate Models as Complementary Tools for Gaining Mechanistic Insight on Muscle Responses to Spaceflight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8430797/"
        ),
        Publication(
            id = "PMC5460135",
            "Investigation of simulated microgravity effects on Streptococcus mutans physiology and global gene expression.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5460135/"
        ),
        Publication(
            id = "PMC10774393",
            "Altered quorum sensing and physiology of Staphylococcus aureus during spaceflight detected by multi-omics data analysis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10774393/"
        ),
        Publication(
            id = "PMC6126739",
            "Homotypic vacuole fusion requires VTI11 and is regulated by phosphoinositides",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6126739/"
        ),
        Publication(
            id = "PMC4411111",
            "REGULATOR OF BULB BIOGENESIS1 (RBB1) Is Involved in Vacuole Bulb Formation in Arabidopsis.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4411111/"
        ),
        Publication(
            id = "PMC6126739",
            "Phosphoinositides control the localization of HOPS subunit VPS41, which together with VPS33 mediates vacuole fusion in plants.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6126739/"
        ),
        Publication(
            id = "PMC9445043",
            "Microgravity enhances the phenotype of Arabidopsis zigzag-1 and reduces the Wortmannin-induced vacuole fusion in root cells.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9445043/"
        ),
        Publication(
            id = "PMC3509447",
            "Hypergravity disruption of homeorhetic adaptations to lactation in rat dams include changes in circadian clocks",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3509447/"
        ),
        Publication(
            id = "PMC5600826",
            "Intrauterine exposure to maternal stress alters Bdnf IV DNA methylation and telomere length in the brain of adult rat offspring.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5600826/"
        ),
        Publication(
            id = "PMC10831389",
            "Influence of gonadectomy on muscle health in micro- and partial-gravity environments in rats.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10831389/"
        ),
        Publication(
            id = "PMC10831389",
            "Sex differences in muscle health in simulated micro- and partial-gravity environments in rats.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10831389/"
        ),
        Publication(
            id = "PMC4507784",
            "Brassinazole resistant 1 (BZR1)-dependent brassinosteroid signalling pathway leads to ectopic activation of quiescent cell division and suppresses columella stem cell differentiation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4507784/"
        ),
        Publication(
            id = "PMC4349987",
            "Proteomic study of microsomal proteins reveals a key role for Arabidopsis Annexin 1 in mediating heat stress-induced increase in intracellular calcium levels.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4349987/"
        ),
        Publication(
            id = "PMC6638264",
            "Apyrase inhibitors enhance the ability of diverse fungicides to inhibit the growth of different plant-pathogenic fungi",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6638264/"
        ),
        Publication(
            id = "PMC6130020",
            "ANN1 and ANN2 Function in Post-Phloem Sugar Transport in Root Tips to Affect Primary Root Growth",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6130020/"
        ),
        Publication(
            id = "PMC9695374",
            "Mitochondria-targeted human catalase in the mouse longevity MCAT model mitigates head-tilt bedrest-induced neuro-inflammation in the hippocampus.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9695374/"
        ),
        Publication(
            id = "PMC6141014",
            "Structural and functional properties of bone are compromised in amyotrophic lateral sclerosis mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6141014/"
        ),
        Publication(
            id = "PMC6706399",
            "Longitudinal time course of muscle impairments during partial weight-bearing in rats",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6706399/"
        ),
        Publication(
            id = "PMC12034070",
            "The partial weight-bearing rat model using a pelvic harness does not impact stress or hindlimb blood flow.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC12034070/"
        ),
        Publication(
            id = "PMC7235020",
            "Dose-dependent skeletal deficits due to varied reductions in mechanical loading in rats.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7235020/"
        ),
        Publication(
            id = "PMC7599661",
            "Approaching Gravity as a Continuum Using the Rat Partial Weight-Bearing Model",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7599661/"
        ),
        Publication(
            id = "PMC8493566",
            "Hindlimb suspension in Wistar rats: Sex-based differences in muscle response",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8493566/"
        ),
        Publication(
            id = "PMC10926278",
            "Adaptation to full weight-bearing following disuse in rats: The impact of biological sex on musculoskeletal recovery",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10926278/"
        ),
        Publication(
            id = "PMC6069985",
            "Effects of liquid cultivation on gene expression and phenotype of C. elegans.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6069985/"
        ),
        Publication(
            id = "PMC9856674",
            "Transcriptomic Signature of the Simulated Microgravity Response in Caenorhabditis elegans and Comparison to Spaceflight Experiments.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9856674/"
        ),
        Publication(
            id = "PMC9410522",
            "Enabling clonal analyses of yeast in outer space by encapsulation and desiccation in hollow microparticles.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9410522/"
        ),
        Publication(
            id = "PMC10344948",
            "Caenorhabditis elegans in microgravity: An omics perspective",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10344948/"
        ),
        Publication(
            id = "PMC4750446",
            "Dried plum diet protects from bone loss caused by ionizing radiation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4750446/"
        ),
        Publication(
            id = "PMC7162976",
            "Dietary countermeasure mitigates simulated spaceflight-induced osteopenia in mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7162976/"
        ),
        Publication(
            id = "PMC11353732",
            "Simulated microgravity alters gene regulation linked to immunity and cardiovascular disease",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11353732/"
        ),
        Publication(
            id = "PMC11953390",
            "Autophagy and its consequences for platelet biology",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11953390/"
        ),
        Publication(
            id = "PMC9737020",
            "A new role of NAP1L1 in megakaryocytes and human platelets",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9737020/"
        ),
        Publication(
            id = "PMC5515519",
            "Evaluation of rodent spaceflight in the NASA animal enclosure module for an extended operational period (up to 35 days)",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5515519/"
        ),
        Publication(
            id = "PMC10144393",
            "Morphology of Penicillium rubens Biofilms Formed in Space",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10144393/"
        ),
        Publication(
            id = "PMC10719374",
            "Explainable machine learning identifies multi-omics signatures of muscle response to spaceflight in mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10719374/"
        ),
        Publication(
            id = "PMC11096397",
            "Microbial adaptation to spaceflight is correlated with bacteriophage-encoded functions",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11096397/"
        ),
        Publication(
            id = "PMC11166655",
            "Influence of the spaceflight environment on macrophage lineages",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166655/"
        ),
        Publication(
            id = "PMC7937622",
            "MARSBOx: Fungal and bacterial endurance from a balloon-flown analog mission in the stratosphere",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7937622/"
        ),
        Publication(
            id = "PMC7055474",
            "In situ linkage of fungal and bacterial proliferation to microbiologically influenced corrosion in B20 biodiesel storage tanks.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7055474/"
        ),
        Publication(
            id = "PMC7118179",
            "Identification of metagenome-assembled genomes containing antimicrobial resistance genes, isolated from an advanced water treatment facility.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7118179/"
        ),
        Publication(
            id = "PMC4494396",
            "Nature of pre-earthquake phenomena and their effects on living organisms",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4494396/"
        ),
        Publication(
            id = "PMC8323809",
            "The rapid diagnosis and effective inhibition of coronavirus using spike antibody attached gold nanoparticles",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8323809/"
        ),
        Publication(
            id = "PMC8886715",
            "Blocking SARS-CoV-2 Delta variant (B.1.617.2) spike protein receptor-binding domain binding with the ACE2 receptor of the host cell and inhibiting virus infections using human host defense peptide-conjugated graphene quantum dots.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8886715/"
        ),
        Publication(
            id = "PMC8890767",
            "Safety and pharmacokinetics of intranasally administered heparin",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8890767/"
        ),
        Publication(
            id = "PMC9487896",
            "Inhibition of SARS-CoV-2 wild-type (Wuhan-Hu-1) and Delta (B.1.617.2) strains by marine sulfated glycans.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9487896/"
        ),
        Publication(
            id = "PMC10142442",
            "Inhibition of Cytomegalovirus by Pentacta pygmaea Fucosylated Chondroitin Sulfate Depends on Its Molecular Weight",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10142442/"
        ),
        Publication(
            id = "PMC11477029",
            "Effect of simulated cosmic radiation on cytomegalovirus reactivation and lytic replication",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11477029/"
        ),
        Publication(
            id = "PMC4309301",
            "A Tissue Retrieval and Postharvest Processing Regimen for Rodent Reproductive Tissues Compatible with Long-Term Storage on the International Space Station and Postflight Biospecimen Sharing Program",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4309301/"
        ),
        Publication(
            id = "PMC11166981",
            "Effects of sex and gender on adaptations to space: reproductive health",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166981/"
        ),
        Publication(
            id = "PMC6343501",
            "Effects of spaceflight on the muscles of the murine shoulder.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6343501/"
        ),
        Publication(
            id = "PMC7138367",
            "Multiscale effects of spaceflight on murine tendon and bone",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7138367/"
        ),
        Publication(
            id = "PMC6689164",
            "Reproducible changes in the gut microbiome suggest a shift in microbial and host metabolism during spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6689164/"
        ),
        Publication(
            id = "PMC3564669",
            "Failure to Generate Bone Marrow Adipocytes Does Not Protect Mice from Ovariectomy-Induced Osteopenia",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3564669/"
        ),
        Publication(
            id = "PMC4042434",
            "Acute exposure to high dose gamma-radiation results in transient activation of bone lining cells",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4042434/"
        ),
        Publication(
            id = "PMC4161659",
            "Morbid obesity attenuates the skeletal abnormalities associated with leptin deficiency in mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4161659/"
        ),
        Publication(
            id = "PMC4917201",
            "Hypothalamic leptin gene therapy reduces body weight without accelerating age-related bone loss",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4917201/"
        ),
        Publication(
            id = "PMC4985531",
            "Hypothalamic Leptin Gene Therapy Reduces Bone Marrow Adiposity in ob/ob Mice Fed Regular and High-Fat Diets.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4985531/"
        ),
        Publication(
            id = "PMC5421618",
            "Room temperature housing results in premature cancellous bone loss in growing female mice: implications for the mouse as a preclinical model for age-related bone loss.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5421618/"
        ),
        Publication(
            id = "PMC5515514",
            "Spaceflight-induced vertebral bone loss in ovariectomized rats is associated with increased bone marrow adiposity and no change in bone formation",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5515514/"
        ),
        Publication(
            id = "PMC8671758",
            "Role of oestrogen receptor signaling in skeletal response to leptin in female ob/ob mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8671758/"
        ),
        Publication(
            id = "PMC5771473",
            "Effects of hypothalamic leptin gene therapy on osteopetrosis in leptin-deficient mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5771473/"
        ),
        Publication(
            id = "PMC5288125",
            "Leptin stimulates bone formation in ob/ob mice at doses having minimal impact on energy metabolism.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5288125/"
        ),
        Publication(
            id = "PMC5389344",
            "Bone Marrow Adipose Tissue Deficiency Increases Disuse-Induced Bone Loss in Male Mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5389344/"
        ),
        Publication(
            id = "PMC9784906",
            "Metabolic Coupling Between Bone Marrow Adipose Tissue and Hematopoiesis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9784906/"
        ),
        Publication(
            id = "PMC6548323",
            "Maintenance of near normal bone mass and architecture in lethally irradiated female mice following adoptive transfer with as few as 750 purified hematopoietic stem cells.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6548323/"
        ),
        Publication(
            id = "PMC6597714",
            "Effect of leptin deficiency on the skeletal response to hindlimb unloading in adult male mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6597714/"
        ),
        Publication(
            id = "PMC6865368",
            "Thermoneutral housing attenuates premature cancellous bone loss in male C57BL/6J mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6865368/"
        ),
        Publication(
            id = "PMC7907224",
            "Effects of Spaceflight on Cancellous and Cortical Bone in Proximal Femur in Growing Rats",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7907224/"
        ),
        Publication(
            id = "PMC8213760",
            "Evidence for increased thermogenesis in female C57BL/6J mice housed aboard the international space station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8213760/"
        ),
        Publication(
            id = "PMC9582271",
            "Leptin and environmental temperature as determinants of bone marrow adiposity in female mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9582271/"
        ),
        Publication(
            id = "PMC10063413",
            "Small changes in thermoregulation influence cancellous bone turnover balance in distal femur metaphysis in growing female mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10063413/"
        ),
        Publication(
            id = "PMC10889206",
            "Bone Marrow Adipose Tissue Is Not Required for Reconstitution of the Immune System Following Irradiation in Male Mice",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10889206/"
        ),
        Publication(
            id = "PMC8468678",
            "Simulated Microgravity Promotes Horizontal Gene Transfer of Antimicrobial Resistance Genes between Bacterial Genera in the Absence of Antibiotic Selective Pressure",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8468678/"
        ),
        Publication(
            id = "PMC9031868",
            "Understanding the Complexities and Changes of the Astronaut Microbiome for Successful Long-Duration Space Missions",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9031868/"
        ),
        Publication(
            id = "PMC10030976",
            "Toward sustainable space exploration: a roadmap for harnessing the power of microorganisms.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10030976/"
        ),
        Publication(
            id = "PMC5910807",
            "Roll maneuvers are essential for active reorientation of Caenorhabditis elegans in 3D media",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5910807/"
        ),
        Publication(
            id = "PMC12021249",
            "Microfluidic Device for Studying Nematodes",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC12021249/"
        ),
        Publication(
            id = "PMC6057834",
            "NemaFlex: A microfluidics-based technology for standardized measurement of muscular strength of C. elegans.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6057834/"
        ),
        Publication(
            id = "PMC6876156",
            "Swim exercise in Caenorhabditis elegans extends neuromuscular and gut healthspan, enhances learning ability, and protects against neurodegeneration",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6876156/"
        ),
        Publication(
            id = "PMC7415877",
            "Molecular muscle experiment: Hardware and operational lessons for future astrobiology space experiments",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7415877/"
        ),
        Publication(
            id = "PMC7285199",
            "Tart Cherry Increases Lifespan in Caenorhabditis elegans by Altering Metabolic Signaling Pathways",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7285199/"
        ),
        Publication(
            id = "PMC9549344",
            "A region of UNC-89 (obscurin) lying between two protein kinase domains is a highly elastic spring required for proper sarcomere organization",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9549344/"
        ),
        Publication(
            id = "PMC7530743",
            "NemaLife chip: a micropillar-based microfluidic culture device optimized for aging studies in crawling C. elegans",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7530743/"
        ),
        Publication(
            id = "PMC7890410",
            "Spaceflight affects neuronal morphology and alters transcellular degradation of neuronal debris in adult Caenorhabditis elegans",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7890410/"
        ),
        Publication(
            id = "PMC9640571",
            "Microfluidics-integrated spaceflight hardware for measuring muscle strength of Caenorhabditis elegans on the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9640571/"
        ),
        Publication(
            id = "PMC9862956",
            "A Compact Imaging Platform for Conducting C. elegans Phenotypic Assays on Earth and in Spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9862956/"
        ),
        Publication(
            id = "PMC10410709",
            "Mitochondrial sulfide promotes life span and health span through distinct mechanisms in developing versus adult treated Caenorhabditis elegans.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10410709/"
        ),
        Publication(
            id = "PMC10751425",
            "Bisphosphonates attenuate age-related muscle decline in Caenorhabditis elegans.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10751425/"
        ),
        Publication(
            id = "PMC10605753",
            "Spaceflight Induces Strength Decline in Caenorhabditis elegans",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10605753/"
        ),
        Publication(
            id = "PMC10846184",
            "Metabolic model predictions enable targeted microbiome manipulation through precision prebiotics.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10846184/"
        ),
        Publication(
            id = "PMC11166967",
            "Transcriptomics analysis reveals molecular alterations underpinning spaceflight dermatology.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11166967/"
        ),
        Publication(
            id = "PMC11302229",
            "Identification and characterization of a skin microbiome on Caenorhabditis elegans suggests environmental microbes confer cuticle protection",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11302229/"
        ),
        Publication(
            id = "PMC11487192",
            "Protein kinase 2 of the giant sarcomeric protein UNC-89 regulates mitochondrial morphology and function",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11487192/"
        ),
        Publication(
            id = "PMC3554398",
            "New perspectives on viable microbial communities in low-biomass cleanroom environments",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3554398/"
        ),
        Publication(
            id = "PMC10370681",
            "Microbial existence in controlled habitats and their resistance to space conditions",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10370681/"
        ),
        Publication(
            id = "PMC4624184",
            "Microbiomes of the dust particles collected from the International Space Station and Spacecraft assembly facilities",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4624184/"
        ),
        Publication(
            id = "PMC4945788",
            "Draft genome sequences of two Aspergillus fumigatus strains, isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4945788/"
        ),
        Publication(
            id = "PMC9116463",
            "Characterization of Aspergillus fumigatus isolates from air and surfaces of the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9116463/"
        ),
        Publication(
            id = "PMC5201052",
            "Draft genome sequences of biosafety level 2 opportunistic pathogens isolated from the environmental surfaces of the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5201052/"
        ),
        Publication(
            id = "PMC5391430",
            "Draft Genome Sequences of Several Fungal Strains Selected for Exposure to Microgravity at the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5391430/"
        ),
        Publication(
            id = "PMC5504618",
            "Human presence impacts fungal diversity of inflated lunar/Mars analog habitat.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5504618/"
        ),
        Publication(
            id = "PMC5580210",
            "Whole metagenome profiles of particulates collected from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5580210/"
        ),
        Publication(
            id = "PMC8421509",
            "Microbial Characteristics of ISS Environmental Surfaces",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8421509/"
        ),
        Publication(
            id = "PMC5552977",
            "Draft Genome Sequences from a Novel Clade of Bacillus cereus Sensu Lato Strains, Isolated from the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5552977/"
        ),
        Publication(
            id = "PMC5805884",
            "Draft Genome Sequences of Acinetobacter and Bacillus Strains Isolated from Spacecraft-Associated Surfaces",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5805884/"
        ),
        Publication(
            id = "PMC5864415",
            "KatharoSeq enables high-throughput microbiome analysis from low-biomass samples",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5864415/"
        ),
        Publication(
            id = "PMC6013642",
            "Draft genome sequence of a clinical isolate of Fusarium fujikuroi isolated from a male patient with acute myeloid leukemia.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6013642/"
        ),
        Publication(
            id = "PMC5578834",
            "Draft Genome Sequence of Solibacillus kalamii, Isolated from an Air Filter Aboard the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5578834/"
        ),
        Publication(
            id = "PMC9241228",
            "Detection of antimicrobial resistance genes associated with the International Space Station environmental surfaces",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9241228/"
        ),
        Publication(
            id = "PMC5958250",
            "Draft genome sequences of two Fusarium oxysporum isolates cultured from infected Zinnia hybrida plants grown on the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5958250/"
        ),
        Publication(
            id = "PMC7326050",
            "Characterization of Aspergillus niger Isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7326050/"
        ),
        Publication(
            id = "PMC6251167",
            "Multi-drug resistant Enterobacter bugandensis species isolated from the International Space Station and comparative genomic analyses with human pathogenic strains",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6251167/"
        ),
        Publication(
            id = "PMC6280456",
            "Succession and persistence of microbial communities and antimicrobial resistance genes associated with International Space Station environmental surfaces",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6280456/"
        ),
        Publication(
            id = "PMC9098231",
            "International Space Station conditions alter genomics, proteomics, and metabolomics in Aspergillus nidulans.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9098231/"
        ),
        Publication(
            id = "PMC9116463",
            "Proteomic characterization of Aspergillus fumigatus isolated from air and surfaces of the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9116463/"
        ),
        Publication(
            id = "PMC6426649",
            "Genomic Characterization and Virulence Potential of Two Fusarium oxysporum Isolates Cultured from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6426649/"
        ),
        Publication(
            id = "PMC6452512",
            "Characterization of the total and viable bacterial and fungal communities associated with the International Space Station surfaces.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6452512/"
        ),
        Publication(
            id = "PMC6529585",
            "Proteomic and Metabolomic Characteristics of Extremophilic Fungi Under Simulated Mars Conditions.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6529585/"
        ),
        Publication(
            id = "PMC6952069",
            "MetaMiner: A Scalable Peptidogenomics Approach for Discovery of Ribosomal Peptide Natural Products with Blind Modifications from Microbial Communities",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6952069/"
        ),
        Publication(
            id = "PMC7303416",
            "Draft Genome Sequences of Sphingomonas Species Associated with the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7303416/"
        ),
        Publication(
            id = "PMC7317102",
            "Draft Genome Sequences of Tremellomycetes Strains Isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7317102/"
        ),
        Publication(
            id = "PMC7393961",
            "Draft Genome Sequences of Rhodotorula mucilaginosa Strains Isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7393961/"
        ),
        Publication(
            id = "PMC7484075",
            "Draft Genome Sequences of Enterobacteriales Strains Isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7484075/"
        ),
        Publication(
            id = "PMC7516158",
            "Draft Genome Sequences of Lactobacillales Isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7516158/"
        ),
        Publication(
            id = "PMC7561690",
            "Draft Genome Sequences of Klebsiella Species Isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7561690/"
        ),
        Publication(
            id = "PMC7595942",
            "Draft Genome Sequences of Bacillaceae Strains Isolated from the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7595942/"
        ),
        Publication(
            id = "PMC7677455",
            "Assessing the risk of transfer of microorganisms at the International Space Station due to cargo delivery by commercial resupply vehicles",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7677455/"
        ),
        Publication(
            id = "PMC8005752",
            "Methylobacterium ajmalii sp. nov., isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8005752/"
        ),
        Publication(
            id = "PMC8104057",
            "Draft Genome Sequences of Aspergillus and Penicillium Species Isolated from the International Space Station and Crew Resupply Vehicle Capsule",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8104057/"
        ),
        Publication(
            id = "PMC8012687",
            "Effects of simulated microgravity on the proteome and secretome of the polyextremotolerant black fungus Knufia chersonesos.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8012687/"
        ),
        Publication(
            id = "PMC8086211",
            "Draft Genome Sequences of Various Bacterial Phyla Isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8086211/"
        ),
        Publication(
            id = "PMC8211661",
            "Evaluating the lettuce metatranscriptome with MinION sequencing for future spaceflight food production applications",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8211661/"
        ),
        Publication(
            id = "PMC11988970",
            "Investigation of Spaceflight Induced Changes to Astronaut Microbiomes",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11988970/"
        ),
        Publication(
            id = "PMC8754149",
            "Genomic Characterization of Potential Plant Growth-Promoting Features of Sphingomonas Strains Isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8754149/"
        ),
        Publication(
            id = "PMC8875396",
            "Genomic Characterization of the Titan-like Cell Producing Naganishia tulchinskyi, the First Novel Eukaryote Isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8875396/"
        ),
        Publication(
            id = "PMC9258157",
            "Metabolic modeling of the International Space Station microbiome reveals key microbial interactions.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9258157/"
        ),
        Publication(
            id = "PMC9503880",
            "Microbial Burden Estimation of Food Items, Built Environments, and the International Space Station Using Film Media",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9503880/"
        ),
        Publication(
            id = "PMC9743659",
            "Multidrug-resistant Acinetobacter pittii is adapting to and exhibiting potential succession aboard the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9743659/"
        ),
        Publication(
            id = "PMC10233975",
            "Characterization of metagenome-assembled genomes from the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10233975/"
        ),
        Publication(
            id = "PMC10308117",
            "Comparative genomic analysis of Cohnella hashimotonis sp. nov. isolated from the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10308117/"
        ),
        Publication(
            id = "PMC10715203",
            "Genomic analysis reveals the presence of emerging pathogenic Klebsiella lineages aboard the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10715203/"
        ),
        Publication(
            id = "PMC10628120",
            "Phylogenomics, phenotypic, and functional traits of five novel (Earth-derived) bacterial species isolated from the International Space Station and their prevalence in metagenomes",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10628120/"
        ),
        Publication(
            id = "PMC10960378",
            "Genomic, functional, and metabolic enhancements in multidrug-resistant Enterobacter bugandensis facilitating its persistence and succession in the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10960378/"
        ),
        Publication(
            id = "PMC10628120",
            "Phylogenomics, phenotypic, and functional traits of five novel (Earth-derived) bacterial species isolated from the International Space Station and their prevalence in metagenomes",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10628120/"
        ),
        Publication(
            id = "PMC11451251",
            "Adaptation to space conditions of novel bacterial species isolated from the International Space Station revealed by functional gene annotations and comparative genome analysis",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11451251/"
        ),
        Publication(
            id = "PMC5523082",
            "Spatial regulation of a common precursor from two distinct genes generates metabolite diversity",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5523082/"
        ),
        Publication(
            id = "PMC6590338",
            "Recent advances in the genome mining of Aspergillus secondary metabolites (covering 2012‚Äì2018).",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6590338/"
        ),
        Publication(
            id = "PMC6036641",
            "Cortical thinning and structural bone changes in non-human primates after single-fraction whole-chest irradiation.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6036641/"
        ),
        Publication(
            id = "PMC6599637",
            "Knee and Hip Joint Cartilage Damage from Combined Spaceflight Hazards of Low-Dose Radiation Less than 1 Gy and Prolonged Hindlimb Unloading.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6599637/"
        ),
        Publication(
            id = "PMC8274610",
            "The individual and combined effects of spaceflight radiation and microgravity on biologic systems and functional outcomes",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8274610/"
        ),
        Publication(
            id = "PMC8131644",
            "Spaceflight and hind limb unloading induces an arthritic phenotype in knee articular cartilage and menisci of rodents",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8131644/"
        ),
        Publication(
            id = "PMC9163032",
            "Œ±Klotho decreases after reduced weight-bearing from both spaceflight and hindlimb unloading",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9163032/"
        ),
        Publication(
            id = "PMC5568470",
            "Prolonged exposure to particulate chromate inhibits RAD51 nuclear import mediator proteins.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5568470/"
        ),
        Publication(
            id = "PMC5485990",
            "Transcriptomics, NF-Œ∫B Pathway, and Their Potential Spaceflight-Related Health Consequences.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5485990/"
        ),
        Publication(
            id = "PMC5460239",
            "Interplay of space radiation and microgravity in DNA damage and DNA damage response.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5460239/"
        ),
        Publication(
            id = "PMC6275019",
            "Synergistic Effects of Weightlessness, Isoproterenol, and Radiation on DNA Damage Response and Cytokine Production in Immune Cells",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6275019/"
        ),
        Publication(
            id = "PMC5397022",
            "Transcriptome and proteome responses in RNAlater preserved tissue of Arabidopsis thaliana.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5397022/"
        ),
        Publication(
            id = "PMC7251690",
            "Spaceflight induces novel regulatory responses in Arabidopsis seedling as revealed by combined proteomic and transcriptomic analyses.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7251690/"
        ),
        Publication(
            id = "PMC10284894",
            "Mitigation and use of biofilms in space for the benefit of human space exploration",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10284894/"
        ),
        Publication(
            id = "PMC10030976",
            "Toward sustainable space exploration: A roadmap for harnessing the power of microorganisms.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10030976/"
        ),
        Publication(
            id = "PMC8421509",
            "Longitudinal characterization of multispecies microbial populations recovered from spaceflight potable water",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8421509/"
        ),
        Publication(
            id = "PMC9964234",
            "Designing a Novel Monitoring Approach for the Effects of Space Travel on Astronauts‚Äô Health",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9964234/"
        ),
        Publication(
            id = "PMC10793275",
            "Draft genome sequence of Sphingomonas paucimobilis strain Sph5, isolated from tap water filtration membrane",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10793275/"
        ),
        Publication(
            id = "PMC4116675",
            "Overexpression of CupB5 activates alginate overproduction in Pseudomonas aeruginosa by a novel AlgW-dependent mechanism",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4116675/"
        ),
        Publication(
            id = "PMC5810432",
            "Burn injury-associated MHCII(+) immune cell accumulation around lymphatic vessels of the mesentery and increased lymphatic endothelial permeability are blocked by doxycycline treatment.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5810432/"
        ),
        Publication(
            id = "PMC10261121",
            "CubeSats for microbiology and astrobiology research",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10261121/"
        ),
        Publication(
            id = "PMC8739323",
            "In situ resource utilisation: The potential for space biomining",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8739323/"
        ),
        Publication(
            id = "PMC8739323",
            "The smallest space miners: Principles of space biomining",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8739323/"
        ),
        Publication(
            id = "PMC9502502",
            "Simulated micro-, lunar, and Martian gravities on Earth‚Äîeffects on Escherichia coli growth, phenotype, and sensitivity to antibiotics.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9502502/"
        ),
        Publication(
            id = "PMC10432549",
            "Biofilm formation of Pseudomonas aeruginosa in spaceflight is minimized on lubricant impregnated surfaces.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10432549/"
        ),
        Publication(
            id = "PMC7261848",
            "Competitive Growth Assay of Mutagenized Chlamydomonas reinhardtii Compatible With the International Space Station Veggie Plant Growth Chamber.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7261848/"
        ),
        Publication(
            id = "PMC8537831",
            "Spatial Characterization of Microbial Communities on Multi-Species Leafy Greens Grown Simultaneously in the Vegetable Production Systems on the International Space Station",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8537831/"
        ),
        Publication(
            id = "PMC8879990",
            "Response of Arabidopsis thaliana and Mizuna mustard seeds to simulated space radiation exposures.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8879990/"
        ),
        Publication(
            id = "PMC10472590",
            "Editorial: Revisiting the limits of plant life - plant adaptations to extreme terrestrial environments relating to astrobiology and space biology.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10472590/"
        ),
        Publication(
            id = "PMC11999716",
            "Metagenomic interrogation of urban Superfund site reveals antimicrobial resistance reservoir and bioremediation potential.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11999716/"
        ),
        Publication(
            id = "PMC11969330",
            "In situ monitoring of barrier function on-chip via automated, non-invasive luminescence sensing.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11969330/"
        ),
        Publication(
            id = "PMC11940681",
            "37-day microgravity exposure in 16-week female C57BL/6J mice is associated with bone loss specific to weight-bearing skeletal sites.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11940681/"
        ),
        Publication(
            id = "PMC11941215",
            "Effects of Space Flight on Inflammasome Activation in the Brain of Mice.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11941215/"
        ),
        Publication(
            id = "PMC11892206",
            "Immunization induces inflammation in the mouse heart during spaceflight.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11892206/"
        ),
        Publication(
            id = "PMC11748630",
            "Analyzing the relationship between gene expression and phenotype in space-flown mice using a causal inference machine learning ensemble.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11748630/"
        ),
        Publication(
            id = "PMC11659408",
            "Sex-specific cardiovascular adaptations to simulated microgravity in Sprague-Dawley rats",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11659408/"
        ),
        Publication(
            id = "PMC11701653",
            "NASA open science data repository: Open science for life in space.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11701653/"
        ),
        Publication(
            id = "PMC11593819",
            "Artificial gravity attenuates the transcriptomic response to spaceflight in the optic nerve and retina",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11593819/"
        ),
        Publication(
            id = "PMC11477029",
            "Effect of simulated cosmic radiation on cytomegalovirus reactivation and lytic replication.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11477029/"
        ),
        Publication(
            id = "PMC11487192",
            "Protein kinase 2 of the giant sarcomeric protein UNC-89 regulates mitochondrial morphology and function.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11487192/"
        ),
        Publication(
            id = "PMC11484870",
            "To boldly go where no microRNAs have gone before: Spaceflight impact on risk for small-for-gestational-age infants.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11484870/"
        ),
        Publication(
            id = "PMC11451251",
            "Adaptation to space conditions of novel bacterial species isolated from the International Space Station revealed by functional gene annotations and comparative genome analysis.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11451251/"
        ),
        Publication(
            id = "PMC11403809",
            "Celebrating 30 years of access to NASA space life sciences data.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11403809/"
        ),
        Publication(
            id = "PMC11386075",
            "Predicting how varying moisture conditions impact the microbiome of dust collected from the International Space Station.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11386075/"
        ),
        Publication(
            id = "PMC11362537",
            "Spaceflight alters host-gut microbiota interactions.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11362537/"
        ),
        Publication(
            id = "PMC11339457",
            "Discoveries from human stem cell research in space that are relevant to advancing cellular therapies on Earth.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11339457/"
        ),
        Publication(
            id = "PMC11324864",
            "Simulated microgravity impairs human NK [natural killer] cell cytotoxic activity against space radiation-relevant leukemic cells.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11324864/"
        ),
        Publication(
            id = "PMC11353732",
            "Simulated microgravity alters gene regulation linked to immunity and cardiovascular disease.",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11353732/"
        ),
        Publication(
            id = "PMC11271499",
            "Spaceflight increases sarcoplasmic reticulum Ca2+ leak and this cannot be counteracted with BuOE treatment",
            link = "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC11271499/"
        ),
    ).fastDistinctBy { it.id }

    fun getAllPubs() = publications

    @OptIn(ExperimentalTime::class)
    fun suggestPublications(maxSuggestionsCount: Int = MAX_SUGGESTIONS_SIZE): List<Publication> {
        val random = Random(millisNow())
        return getAllPubs()
            .shuffled(random)
            .take(maxSuggestionsCount)
    }

    fun publicationById(id: String): Publication {
        return publications.find { it.id == id }!!
    }

}