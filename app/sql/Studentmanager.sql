USE [java]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 1/20/2019 9:32:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin](
	[id] [nchar](10) NOT NULL,
	[username] [nchar](10) NULL,
	[password] [nchar](10) NULL,
 CONSTRAINT [PK_admin] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[student]    Script Date: 1/20/2019 9:32:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student](
	[ID] [nvarchar](50) NOT NULL,
	[LỚP] [nvarchar](50) NULL,
	[PASS] [nvarchar](50) NULL,
	[TÊN] [nvarchar](50) NULL,
	[toan] [float] NULL,
	[ly] [float] NULL,
	[hoa] [float] NULL,
 CONSTRAINT [PK_student] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
