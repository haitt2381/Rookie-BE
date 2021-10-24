DROP DATABASE IF EXISTS rookie2;
--
-- Name: rookie; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE rookie2;


ALTER DATABASE rookie OWNER TO postgres;

--
-- Name: authorities_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.authorities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.authorities_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: delivery_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.delivery_info (
    id integer NOT NULL,
    recipient_name character varying NOT NULL,
    phone_number character varying NOT NULL,
    email character varying NOT NULL,
    address character varying NOT NULL
);


ALTER TABLE public.delivery_info OWNER TO postgres;

--
-- Name: delivery_info_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.delivery_info_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.delivery_info_id_seq OWNER TO postgres;

--
-- Name: delivery_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.delivery_info_id_seq OWNED BY public.delivery_info.id;


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: order_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_details (
    id integer NOT NULL,
    order_id integer,
    product_id integer,
    quantity integer NOT NULL,
    price money NOT NULL
);


ALTER TABLE public.order_details OWNER TO postgres;

--
-- Name: order_details_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_details_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.order_details_id_seq OWNER TO postgres;

--
-- Name: order_details_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.order_details_id_seq OWNED BY public.order_details.id;


--
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    id integer NOT NULL,
    customer_id integer,
    note character varying,
    delivery_info_id integer,
    purchase_date date NOT NULL
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_id_seq OWNER TO postgres;

--
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;


--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying NOT NULL,
    category_id integer NOT NULL,
    price money NOT NULL,
    quantity integer NOT NULL,
    create_date date NOT NULL,
    update_date date NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: products_categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products_categories (
    id integer NOT NULL,
    name character varying NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE public.products_categories OWNER TO postgres;

--
-- Name: products_categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_categories_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_categories_id_seq OWNER TO postgres;

--
-- Name: products_categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_categories_id_seq OWNED BY public.products_categories.id;


--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_id_seq OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- Name: products_images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products_images (
    id integer NOT NULL,
    product_id integer NOT NULL,
    image character varying
);


ALTER TABLE public.products_images OWNER TO postgres;

--
-- Name: products_images_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_images_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_images_id_seq OWNER TO postgres;

--
-- Name: products_images_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_images_id_seq OWNED BY public.products_images.id;


--
-- Name: products_ratings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products_ratings (
    id integer NOT NULL,
    product_id integer NOT NULL,
    rating integer NOT NULL
);


ALTER TABLE public.products_ratings OWNER TO postgres;

--
-- Name: products_ratings_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_ratings_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_ratings_id_seq OWNER TO postgres;

--
-- Name: products_ratings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_ratings_id_seq OWNED BY public.products_ratings.id;


--
-- Name: refresh_token; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.refresh_token (
    id bigint NOT NULL,
    expiry_date timestamp without time zone NOT NULL,
    token character varying(255) NOT NULL,
    user_id bigint
);


ALTER TABLE public.refresh_token OWNER TO postgres;

--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying NOT NULL,
    password character varying NOT NULL,
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    gender boolean NOT NULL,
    email character varying NOT NULL,
    image character varying NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_roles (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.users_roles OWNER TO postgres;

--
-- Name: delivery_info id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery_info ALTER COLUMN id SET DEFAULT nextval('public.delivery_info_id_seq'::regclass);


--
-- Name: order_details id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_details ALTER COLUMN id SET DEFAULT nextval('public.order_details_id_seq'::regclass);


--
-- Name: orders id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);


--
-- Name: products id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- Name: products_categories id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_categories ALTER COLUMN id SET DEFAULT nextval('public.products_categories_id_seq'::regclass);


--
-- Name: products_images id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_images ALTER COLUMN id SET DEFAULT nextval('public.products_images_id_seq'::regclass);


--
-- Name: products_ratings id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_ratings ALTER COLUMN id SET DEFAULT nextval('public.products_ratings_id_seq'::regclass);


--
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: delivery_info; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: order_details; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.products VALUES (2, 'Samsung Galaxy Tab S7 FE', 2, '$13,990,000.00', 100, '2021-09-30', '2021-09-30', 'samsung1.jpg');
INSERT INTO public.products VALUES (3, 'Samsung Galaxy Tab A7 Lite', 2, '$4,490,000.00', 100, '2021-09-30', '2021-09-30', 'samsung2.jpg');
INSERT INTO public.products VALUES (4, 'Samsung Galaxy A22', 2, '$5,290,000.00', 100, '2021-09-30', '2021-09-30', 'samsung3.jpg');
INSERT INTO public.products VALUES (5, 'Samsung Galaxy Z Fold2 5G', 2, '$50,000,000.00', 100, '2021-09-30', '2021-09-30', 'samsung4.jpg');
INSERT INTO public.products VALUES (6, 'Samsung Galaxy Z Fold3 5G 512GB', 2, '$44,990,000.00', 100, '2021-09-30', '2021-09-30', 'samsung5.jpg');
INSERT INTO public.products VALUES (7, 'Huawei MatePad T10s (Ná»�n táº£ng Huawei Mobile Service)', 2, '$5,140,000.00', 100, '2021-09-30', '2021-09-30', 'huawei1.jpg');
INSERT INTO public.products VALUES (8, 'Huawei MatePad 64GB (Ná»�n táº£ng Huawei Mobile Service)', 2, '$6,590,000.00', 100, '2021-09-30', '2021-09-30', 'huawei2.jpg');
INSERT INTO public.products VALUES (9, 'Huawei MatePad 11', 2, '$13,990,000.00', 100, '2021-09-30', '2021-09-30', 'huawei3.jpg');
INSERT INTO public.products VALUES (10, 'Huawei MatePad 128GB (Ná»�n táº£ng Huawei Mobile Service)', 2, '$7,490,000.00', 100, '2021-09-30', '2021-09-30', 'huawei4.jpg');
INSERT INTO public.products VALUES (11, 'Huawei MatePad T8 (Ná»�n táº£ng Huawei Mobile Service)', 2, '$3,090,000.00', 100, '2021-09-30', '2021-09-30', 'huawei5.jpg');
INSERT INTO public.products VALUES (12, 'Lenovo Tab M10 - FHD Plus', 2, '$5,890,000.00', 100, '2021-09-30', '2021-09-30', 'lenovo1.jpg');
INSERT INTO public.products VALUES (13, 'Lenovo Tab M10 - Gen 2', 2, '$4,690,000.00', 100, '2021-09-30', '2021-09-30', 'lenovo2.jpg');
INSERT INTO public.products VALUES (14, 'Lenovo Tab M8 (TB-8505X)', 2, '$3,690,000.00', 100, '2021-09-30', '2021-09-30', 'lenovo3.jpg');
INSERT INTO public.products VALUES (15, 'Lenovo Tab3 8 Plus', 2, '$4,690,000.00', 100, '2021-09-30', '2021-09-30', 'lenovo4.jpg');
INSERT INTO public.products VALUES (16, 'Lenovo Tab 2 A7-10', 2, '$5,890,000.00', 100, '2021-09-30', '2021-09-30', 'lenovo5.jpg');
INSERT INTO public.products VALUES (17, 'iPad Pro M1 12.9 inch WiFi Cellular 256GB (2021)', 2, '$38,490,000.00', 100, '2021-09-30', '2021-09-30', 'apple1.jpg');
INSERT INTO public.products VALUES (18, 'iPad Pro M1 12.9 inch WiFi Cellular 128GB (2021)', 2, '$35,290,000.00', 100, '2021-09-30', '2021-09-30', 'apple2.jpg');
INSERT INTO public.products VALUES (19, 'iPad Pro M1 12.9 inch WiFi 256GB (2021)', 2, '$33,290,000.00', 100, '2021-09-30', '2021-09-30', 'apple3.jpg');
INSERT INTO public.products VALUES (20, 'iPad Pro M1 12.9 inch WiFi 128GB (2021)', 2, '$30,790,000.00', 100, '2021-09-30', '2021-09-30', 'apple4.jpg');
INSERT INTO public.products VALUES (21, 'iPhone 12', 2, '$20,500,000.00', 100, '2021-09-30', '2021-09-30', 'apple5.jpg');
INSERT INTO public.products VALUES (22, 'Xiaomi Redmi 10 (6GB/128GB)', 2, '$4,560,000.00', 100, '2021-09-30', '2021-09-30', 'xiaomi1.jpg');
INSERT INTO public.products VALUES (23, 'Xiaomi Redmi Note 10 5G 8GB', 2, '$5,490,000.00', 100, '2021-09-30', '2021-09-30', 'xiaomi2.jpg');
INSERT INTO public.products VALUES (24, 'Xiaomi Mi 11 5G', 2, '$16,520,000.00', 100, '2021-09-30', '2021-09-30', 'xiaomi3.jpg');
INSERT INTO public.products VALUES (25, 'Xiaomi Mi 10T Pro 5G', 2, '$12,560,000.00', 100, '2021-09-30', '2021-09-30', 'xiaomi4.jpg');
INSERT INTO public.products VALUES (26, 'Xiaomi Mi 11 Lite', 2, '$7,560,000.00', 100, '2021-09-30', '2021-09-30', 'xiaomi5.jpg');
INSERT INTO public.products VALUES (27, 'Nokia 105 4G', 2, '$710,000.00', 100, '2021-09-30', '2021-09-30', 'nokia1.jpg');
INSERT INTO public.products VALUES (28, 'Nokia 6300 4G', 2, '$1,290,000.00', 100, '2021-09-30', '2021-09-30', 'nokia2.jpg');
INSERT INTO public.products VALUES (29, 'Nokia C20', 2, '$1,990,000.00', 100, '2021-09-30', '2021-09-30', 'nokia3.jpg');
INSERT INTO public.products VALUES (30, 'Nokia C30', 2, '$2,790,000.00', 100, '2021-09-30', '2021-09-30', 'nokia4.jpg');
INSERT INTO public.products VALUES (31, 'Nokia 105 Single SIM', 2, '$390,000.00', 100, '2021-09-30', '2021-09-30', 'nokia5.jpg');
INSERT INTO public.products VALUES (32, 'Realme Watch 2 pro dÃ¢y silicone', 4, '$2,690,000.00', 100, '2021-09-30', '2021-09-30', 'realme1.jpg');
INSERT INTO public.products VALUES (33, 'Realme Watch 2 dÃ¢y silicone', 4, '$1,890,000.00', 100, '2021-09-30', '2021-09-30', 'realme2.jpg');
INSERT INTO public.products VALUES (34, 'Asus ExpertBook P2451FA i5 10210U (EK2772T)', 1, '$17,590,000.00', 100, '2021-09-30', '2021-09-30', 'asus1.jpg');
INSERT INTO public.products VALUES (35, 'Asus VivoBook A415EA i3 1115G4 (EB568T)', 1, '$15,900,000.00', 100, '2021-09-30', '2021-09-30', 'asus2.jpg');
INSERT INTO public.products VALUES (36, 'Asus VivoBook A415EA i3 1115G4 (EB559T)', 1, '$15,690,000.00', 100, '2021-09-30', '2021-09-30', 'asus3.jpg');
INSERT INTO public.products VALUES (37, 'Asus VivoBook A415EA i5 1135G7 (AM889T)', 1, '$17,690,000.00', 100, '2021-09-30', '2021-09-30', 'asus4.jpg');
INSERT INTO public.products VALUES (38, 'Asus VivoBook X415EA i5 1135G7 (EB637T)', 1, '$919,690,000.00', 100, '2021-09-30', '2021-09-30', 'asus5.jpg');
INSERT INTO public.products VALUES (39, 'Dell Gaming G3 15 i7 10750H (P89F002BWH)', 1, '$17,590,000.00', 100, '2021-09-30', '2021-09-30', 'dell1.jpg');
INSERT INTO public.products VALUES (40, 'Dell Inspiron 7400 i5 1135G7 (N4I5134W)', 1, '$15,900,000.00', 100, '2021-09-30', '2021-09-30', 'dell2.jpg');
INSERT INTO public.products VALUES (41, 'Dell XPS 13 9310 i7 1165G7 (JGNH62)', 1, '$15,690,000.00', 100, '2021-09-30', '2021-09-30', 'dell3.jpg');
INSERT INTO public.products VALUES (42, 'Dell XPS 13 9310 i5 1135G7 (70231343)', 1, '$17,690,000.00', 100, '2021-09-30', '2021-09-30', 'dell4.jpg');
INSERT INTO public.products VALUES (43, 'Dell Gaming G15 5515 R7 5800H (70258051)', 1, '$19,690,000.00', 100, '2021-09-30', '2021-09-30', 'dell5.jpg');
INSERT INTO public.products VALUES (44, 'Loa JBL XBoom 3', 6, '$26,590,000.00', 100, '2021-09-30', '2021-09-30', 'jbl.jpg');
INSERT INTO public.products VALUES (45, 'Acer Nitro 5 Gaming A515 55 72R2 i7 10870H', 1, '$26,590,000.00', 100, '2021-09-30', '2021-09-30', 'acer1.jpg');
INSERT INTO public.products VALUES (46, 'Acer Nitro 5 Gaming AN515 57 74NU i7 11800H', 1, '$28,900,000.00', 100, '2021-09-30', '2021-09-30', 'acer2.jpg');
INSERT INTO public.products VALUES (47, 'Acer Nitro 5 Gaming AN515 57 5831 i5 11400H', 1, '$31,690,000.00', 100, '2021-09-30', '2021-09-30', 'acer3.jpg');
INSERT INTO public.products VALUES (48, 'Acer Nitro 5 Gaming AN515 57 50FT i5 11400H', 1, '$26,690,000.00', 100, '2021-09-30', '2021-09-30', 'acer4.jpg');
INSERT INTO public.products VALUES (49, 'Acer Nitro 5 AN515 57 51G6 i5 11400H (NH.QD8SV.002)', 1, '$24,690,000.00', 100, '2021-09-30', '2021-09-30', 'acer5.jpg');
INSERT INTO public.products VALUES (50, 'Sáº¡c nhanh Anker Powerport III Nano 20W A2633', 3, '$360,000.00', 100, '2021-09-30', '2021-09-30', 'phukien1.jpg');
INSERT INTO public.products VALUES (51, 'CÃ¡p Type C 2m AVA+ DS08C', 3, '$256,000.00', 100, '2021-09-30', '2021-09-30', 'phukien1.jpg');
INSERT INTO public.products VALUES (52, 'Sáº¡c xe hÆ¡i 2 cá»•ng USB Type C PD 20W Belkin CCB003 Ä�en', 3, '$850,000.00', 100, '2021-09-30', '2021-09-30', 'phukien1.jpg');
INSERT INTO public.products VALUES (53, 'Sáº¡c OPPO OP92KAUH', 3, '$490,000.00', 100, '2021-09-30', '2021-09-30', 'phukien1.jpg');
INSERT INTO public.products VALUES (54, 'CÃ¡p sáº¡c Samsung SAKD05H', 3, '$490,000.00', 100, '2021-09-30', '2021-09-30', 'phukien1.jpg');
INSERT INTO public.products VALUES (55, 'iMac 24 inch 2021 4.5K M1 8GPU (MGPL3SA/A) Blue', 5, '$44,000,000.00', 100, '2021-09-30', '2021-09-30', 'pc1.jpg');
INSERT INTO public.products VALUES (56, 'Robot hÃºt bá»¥i Xiaomi Vacuum Mop Pro', 7, '$9,900,000.00', 100, '2021-09-30', '2021-09-30', 'nhathongminh1.jpg');
INSERT INTO public.products VALUES (57, 'Tai nghe Bluetooth Apple AirPods 2 VN/A', 8, '$3,300,000.00', 100, '2021-09-30', '2021-09-30', 'tainghe1.jpg');
INSERT INTO public.products VALUES (58, 'Asus LCD ProArt PA247CV 23.8 inch Full HD', 9, '$6,900,000.00', 100, '2021-09-30', '2021-09-30', 'manhinh1.jpg');


--
-- Data for Name: products_categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.products_categories VALUES (1, 'lt', 'Laptop');
INSERT INTO public.products_categories VALUES (2, 'dtdd', 'Ä�iá»‡n thoáº¡i di Ä‘á»™ng');
INSERT INTO public.products_categories VALUES (3, 'pk', 'Phá»¥ kiá»‡n');
INSERT INTO public.products_categories VALUES (4, 'dhtm', 'Ä�á»“ng há»“ thÃ´ng minh');
INSERT INTO public.products_categories VALUES (5, 'pc', 'PC');
INSERT INTO public.products_categories VALUES (6, 'loa', 'Loa');
INSERT INTO public.products_categories VALUES (7, 'ntm', 'NhÃ  thÃ´ng minh');
INSERT INTO public.products_categories VALUES (8, 'tn', 'Tai nghe');
INSERT INTO public.products_categories VALUES (9, 'mh', 'MÃ n hÃ¬nh');
INSERT INTO public.products_categories VALUES (10, 'tl', 'Tablet');


--
-- Data for Name: products_images; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: products_ratings; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: refresh_token; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.refresh_token VALUES (48, '2021-10-25 21:50:59.612697', 'ef05ed04-a71d-4218-95d4-ca22006dfd33', 38);


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roles VALUES (2, 'ROLE_USER');
INSERT INTO public.roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.roles VALUES (3, 'ROLE_MODERATOR');


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES (39, 'hiennt', '123', 'Hien', 'Nguyen', true, 'hiennt@gmail.com', 'hiennt.jpg');
INSERT INTO public.users VALUES (1, 'takimtai123', '123456', 'Táº¡', 'Kim TÃ i', true, 'takimtai123@gmai.com', 'kimtai.jpg');
INSERT INTO public.users VALUES (2, 'tranthanhhai', '123456', 'Tráº§n', 'Thanh Háº£i', true, 'tranthanhhai@gmai.com', 'thanhhai.jpg');
INSERT INTO public.users VALUES (3, 'kieutanchien', '123456', 'Kiá»�u', 'TÃ¢n Chiáº¿n', true, 'kieutanchien@gmai.com', 'tanchien.jpg');
INSERT INTO public.users VALUES (4, 'voduchuy', '123456', 'VÃµ', 'Ä�á»©c Huy', false, 'voduchuy@gmai.com', 'duchuy.jpg');
INSERT INTO public.users VALUES (5, 'buinhathoang', '123456', 'BÃ¹i', 'Nháº­t HoÃ ng', false, 'buinhathoang@gmai.com', 'nhathoang.jpg');
INSERT INTO public.users VALUES (6, 'tranthanhtienhai', '123456', 'Tráº§n', 'Thanh Tiáº¿n Háº£i', false, 'tranthanhtienhai@gmai.com', 'tienhai.jpg');
INSERT INTO public.users VALUES (38, 'haitt', '$2a$10$K/2nkul2DIJfYZv5ftRmQ.a0qWVcma1JI8tN.0aHNfZymMl/fbwmy', 'Hai', 'Tran', true, 'tranhai01se@gmail.com', 'haitt.jpg');
INSERT INTO public.users VALUES (41, 'mod', '$2a$10$1SZGVsFEyYrnQdb1/QZTPu0kRJPDIjAi0gZNLXlpCQO1tGhqJgfjC', 'test', 'test', true, 'mod@gmail.com', 'image');
INSERT INTO public.users VALUES (45, 'haitt1', '$2a$10$u10d1ibIQJQ1o6V91NJY3OrhCH9YlD8S47NhQzzV4tpb/eQ12nGYy', 'test', 'test', true, 'tranhai02se@gmail.com', 'image');


--
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users_roles VALUES (1, 1);
INSERT INTO public.users_roles VALUES (2, 1);
INSERT INTO public.users_roles VALUES (3, 1);
INSERT INTO public.users_roles VALUES (4, 2);
INSERT INTO public.users_roles VALUES (5, 2);
INSERT INTO public.users_roles VALUES (6, 2);
INSERT INTO public.users_roles VALUES (38, 2);
INSERT INTO public.users_roles VALUES (38, 3);
INSERT INTO public.users_roles VALUES (38, 1);
INSERT INTO public.users_roles VALUES (41, 2);
INSERT INTO public.users_roles VALUES (45, 2);


--
-- Name: authorities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.authorities_id_seq', 2, true);


--
-- Name: delivery_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.delivery_info_id_seq', 1, false);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 48, true);


--
-- Name: order_details_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_details_id_seq', 1, false);


--
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_id_seq', 1, false);


--
-- Name: products_categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_categories_id_seq', 10, true);


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_id_seq', 58, true);


--
-- Name: products_images_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_images_id_seq', 1, false);


--
-- Name: products_ratings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_ratings_id_seq', 1, false);


--
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 3, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 6, true);


--
-- Name: delivery_info delivery_info_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery_info
    ADD CONSTRAINT delivery_info_pk PRIMARY KEY (id);


--
-- Name: order_details order_details_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_details
    ADD CONSTRAINT order_details_pk PRIMARY KEY (id);


--
-- Name: orders orders_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pk PRIMARY KEY (id);


--
-- Name: products_categories products_categories_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_categories
    ADD CONSTRAINT products_categories_pk PRIMARY KEY (id);


--
-- Name: products_images products_images_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_images
    ADD CONSTRAINT products_images_pk PRIMARY KEY (id);


--
-- Name: products products_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pk PRIMARY KEY (id);


--
-- Name: products_ratings products_ratings_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_ratings
    ADD CONSTRAINT products_ratings_pk PRIMARY KEY (id);


--
-- Name: refresh_token refresh_token_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.refresh_token
    ADD CONSTRAINT refresh_token_pkey PRIMARY KEY (id);


--
-- Name: roles roles_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pk PRIMARY KEY (id);


--
-- Name: refresh_token uk_r4k4edos30bx9neoq81mdvwph; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.refresh_token
    ADD CONSTRAINT uk_r4k4edos30bx9neoq81mdvwph UNIQUE (token);


--
-- Name: users users_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (id);


--
-- Name: users_username_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX users_username_uindex ON public.users USING btree (username);


--
-- Name: refresh_token fkjtx87i0jvq2svedphegvdwcuy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.refresh_token
    ADD CONSTRAINT fkjtx87i0jvq2svedphegvdwcuy FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: order_details order_details_orders_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_details
    ADD CONSTRAINT order_details_orders_id_fk FOREIGN KEY (order_id) REFERENCES public.orders(id);


--
-- Name: order_details order_details_products_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_details
    ADD CONSTRAINT order_details_products_id_fk FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- Name: orders orders_delivery_info_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_delivery_info_id_fk FOREIGN KEY (delivery_info_id) REFERENCES public.delivery_info(id);


--
-- Name: orders orders_users_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_users_id_fk FOREIGN KEY (customer_id) REFERENCES public.users(id);


--
-- Name: products_images products_images_products_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_images
    ADD CONSTRAINT products_images_products_id_fk FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- Name: products products_products_categories_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_products_categories_id_fk FOREIGN KEY (category_id) REFERENCES public.products_categories(id);


--
-- Name: products_ratings products_ratings_products_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_ratings
    ADD CONSTRAINT products_ratings_products_id_fk FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- Name: users_roles users_roles_roles_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT users_roles_roles_id_fk FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- Name: users_roles users_roles_users_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT users_roles_users_id_fk FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- PostgreSQL database dump complete
--

