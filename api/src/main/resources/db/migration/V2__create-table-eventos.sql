CREATE TABLE eventos (
    id BIGINT PRIMARY KEY, -- Chave primária única para cada evento
    nome VARCHAR(255) NOT NULL, -- Nome do evento (obrigatório)
    descricao_resumida VARCHAR(500), -- Breve descrição
    descricao_detalhada TEXT, -- Descrição completa
    data_inicio TIMESTAMP WITHOUT TIME ZONE NOT NULL, -- Data e hora de início (obrigatório)
    data_fim TIMESTAMP WITHOUT TIME ZONE, -- Data e hora de término
    local VARCHAR(255), -- Local físico do evento
    link_mapa VARCHAR(255), -- URL para o mapa do local
    status BOOLEAN DEFAULT TRUE NOT NULL, -- Status do evento (ativo/inativo)
    link_compra VARCHAR(255), -- Link para compra de ingressos

    -- ATRIBUTO CHAVE
    categoria VARCHAR(50) NOT NULL, -- Identifica a categoria principal (ESPORTIVO, CULTURAL, EDUCACIONAL ou GASTRONOMICO.)

    -- --- ATRIBUTOS ESPORTIVOS ---
    modalidade_esportiva VARCHAR(100), -- Ex: Surf, Vôlei de Praia
    nivel_dificuldade VARCHAR(50), -- Ex: Amador, Profissional
    requisitos_participacao TEXT, -- Restrições de idade, experiência, etc.
    regras_evento TEXT, -- Regulamento principal da competição/atividade
    requisitos_equipamento TEXT, -- Ex: Uso obrigatório de colete, prancha

    -- --- ATRIBUTOS CULTURAIS ---
    tipo_arte VARCHAR(100), -- Ex: Música, Teatro, Artesanato
    artista_principal VARCHAR(255), -- Nome do artista/banda/companhia
    formato_cultural VARCHAR(100), -- Ex: Festival, Peça Única, Mostra

    -- --- ATRIBUTOS GASTRONÔMICOS ---
    tema_culinario VARCHAR(100), -- Ex: Frutos do Mar, Cerveja Artesanal
    restaurantes_participantes TEXT, -- Lista de estabelecimentos envolvidos
    formato_gastronomico VARCHAR(100), -- Ex: Rota Gastronômica, Feira

    -- --- ATRIBUTOS EDUCACIONAIS  ---
    instrutores_responsaveis VARCHAR(255), -- Nome do professor ou palestrante
    nivel_escolaridade VARCHAR(50), -- Ex: Básico, Intermediário, Avançado, Ensino Médio
);